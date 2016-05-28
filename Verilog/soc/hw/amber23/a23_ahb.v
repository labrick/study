module a23_ahb(hclk, hresetn, haddr, htrans, hburst, hsize, hwrite, hwdata, hrdata, hready, hresp, irq, fiq);

input hclk;
input hresetn;
input hready;
input [1:0]hresp;
input [31:0]hrdata;
input irq, fiq;
output [31:0]haddr;
output [31:0]hwdata;
output [1:0]htrans;
output [2:0]hburst;
output [1:0]hsize;
output hwrite;

reg [31:0]hwdata;
reg [1:0]cur_st, nxt_st;
reg wb_ack;
reg [1:0]htrans;
wire [31:0]wb_addr;
wire [31:0]wb_rdata;
wire [31:0]wb_wdata;
wire [3:0]wb_sel;


a23_core u_amber
(
.i_clk(hclk),
.i_irq(irq),              // Interrupt request, active high
.i_firq(fiq),             // Fast Interrupt request, active high
.i_system_rdy(hresetn),       // Amber is stalled when this is low
.o_wb_adr(wb_addr),
.o_wb_sel(wb_sel),
.o_wb_we(wb_we),
.i_wb_dat(wb_rdata),
.o_wb_dat(wb_wdata),
.o_wb_cyc(wb_cyc),
.o_wb_stb(wb_stb),
.i_wb_ack(wb_ack),
.i_wb_err(1'b0)
);           

assign haddr = wb_addr;
assign hwrite = wb_stb & wb_we;
assign hsize = ((wb_sel == 4'b0001) || (wb_sel == 4'b0010) || (wb_sel == 4'b0100) || (wb_sel == 4'b1000)) ? 2'b00 :
							 ((wb_sel == 4'b0011) || (wb_sel == 4'b1100)) ? 2'b01 : 2'b10;		
							 					 
assign hburst = 3'b000;

always @(posedge hclk or negedge hresetn)
begin
  if (!hresetn)
    hwdata <= 32'h0;
  else if (hwrite & htrans[1] & hready)
    hwdata <= wb_wdata;
end
    
//assign hwdata = wb_wdata;
assign wb_rdata = hrdata;

parameter IDLE = 2'b00;
parameter TRANS = 2'b01;

always @(posedge hclk or negedge hresetn)
	if (!hresetn)
		cur_st <= IDLE;
  else 
  	cur_st <= nxt_st;
  	
always @*
begin
	nxt_st = cur_st;
	case(cur_st)
		IDLE : if (wb_stb & wb_cyc) nxt_st = TRANS;  	
		TRANS : if (hready) nxt_st = IDLE;
    default: nxt_st = IDLE;
  endcase
end



always @*
begin
	case(cur_st)
		IDLE : begin
						if (wb_stb & wb_cyc) 
						  htrans = 2'b10;
						else 
						  htrans = 2'b00;
						wb_ack = 1'b0;
					end  	
		TRANS : begin
						if (hready) 
						  htrans = 2'b00;
						else
						  htrans = 2'b10;
						wb_ack = hready;
					end
		default : begin
						htrans = 2'b00;
						wb_ack = 1'b0;
					end  	
	endcase
end
							
					

	

endmodule