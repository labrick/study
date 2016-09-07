module timer_apb(
  paddr,
  pclk,
  penable,
  prdata,
  presetn,
  psel,
  pwdata,
  pwrite
);

input   [15:0]  paddr;                 
input           pclk;                  
input           penable;               
input           presetn;               
input           psel;                  
input   [31:0]  pwdata;
input           pwrite;
output  [31:0]  prdata;                


reg     [31:0]  prdata;                
reg     [1 :0]  timer_1_control_reg;   
reg     [31:0]  timer_1_load_count;    
wire    [31:0]  timer_1_current_value;
wire count_mode, count_en;
reg [31:0]counter;


//==========================================================
//                  APB PWDATA
//==========================================================
always @(posedge pclk or negedge presetn)
begin
  if(!presetn)
  begin
    timer_1_load_count <= 32'b0;
    timer_1_control_reg <= 2'b0;
  end
  else
  begin
    if(psel && pwrite && penable)
    begin
      case(paddr[7:2])
        6'b000000:
        begin
          timer_1_load_count <= pwdata;
        end
        6'b000010:
        begin
          timer_1_control_reg <= pwdata[1:0];
        end
      endcase
    end
  end
end


assign {count_mode, count_en} = timer_1_control_reg[1:0];
    
//==========================================================
//                  APB PRDATA
//==========================================================
always @(posedge pclk or negedge presetn)
begin
	if (!presetn)
	  prdata <= 32'h0;
  else if(psel && !pwrite)
  begin
    if (!penable)
	begin
      case(paddr[7:2])
        6'b000000:
        begin
          prdata <= timer_1_load_count;
        end
        6'b000001:
        begin
          prdata <= timer_1_current_value;
        end
        6'b000010:
        begin
          prdata <= {30'h0, timer_1_control_reg};
        end
        default:
        begin
          prdata <= 32'hdeadbeaf;
        end
      endcase
	end
end
	else
	  prdata <= 32'b0;
end


//counter

always @(posedge pclk or negedge presetn)
begin
	if (!presetn)
	  counter <= 32'h0;
	else if (!count_en)
	  counter <= 32'h0;
	else if (count_en)
		begin
			if (count_mode == 1'b0) //one-hot
				begin
					if (counter < timer_1_load_count)
						counter <= counter + 1;
				end
			else if (count_mode == 1'b1)//reload
			  begin
			  	if (counter == timer_1_load_count)
			  		counter <= 32'h0;
			  	else
						counter <= counter + 1;
			  end
		end
end

assign timer_1_current_value = counter;

endmodule