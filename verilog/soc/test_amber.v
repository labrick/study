`timescale 1ns/100ps
module tb;
  
  reg rstn, clk;
  /*wire [31:0]s_wb_adr    ;              
  wire [3:0]s_wb_sel    ;              
  wire [0:0]s_wb_we     ;              
  wire [31:0]s_wb_dat_r  ;              
  wire [31:0]s_wb_dat_w  ;              
  wire s_wb_cyc    ;              
  wire s_wb_stb    ;              
  wire s_wb_ack    ;              
  wire s_wb_err    ;
                
		 a23_core u_amber
					(
					.i_clk(clk),
					.i_irq(1'b0),              // Interrupt request, active high
					.i_firq(1'b0),             // Fast Interrupt request, active high
					.i_system_rdy(1'b1),       // Amber is stalled when this is low
					.i_wb_dat(s_wb_dat_r),
					
					// Wishbone Master I/F
					.o_wb_adr(s_wb_adr),
					.o_wb_sel(s_wb_sel),
					.o_wb_we(s_wb_we),
					.o_wb_dat(s_wb_dat_w),
					.o_wb_cyc(s_wb_cyc),
					.o_wb_stb(s_wb_stb),
					.i_wb_ack(s_wb_ack),
					.i_wb_err(s_wb_err)
					
					);          
					
	    boot_mem32 u_boot_mem (
        .i_wb_clk sim:/tb   ( clk         ),
        .i_wb_adr    ( s_wb_adr    ),
        .i_wb_sel    ( s_wb_sel    ),
        .i_wb_we     ( s_wb_we     ),
        .o_wb_dat    ( s_wb_dat_r  ),
        .i_wb_dat    ( s_wb_dat_w  ),
        .i_wb_cyc    ( s_wb_cyc    ),
        .i_wb_stb    ( s_wb_stb    ),
        .o_wb_ack    ( s_wb_ack    ),
        .o_wb_err    ( s_wb_err    )
    );*/					
    
top U_top(
			.clk(clk), 
			.rstn(rstn)
			);					
  
   reg [7:0]temp_ram[32767:0];
   integer i;
   initial begin
    for (i=0;i<8192*4;i=i+1)
    	temp_ram[i] = 0;

    $readmemh("C:/modeltech64_10.2c/examples/work/sw/first_run/Debug/first_run.vh", temp_ram);
    
    for (i=0;i<8192;i=i+1) begin
      	U_top.U_esram.U_RAM.mem[i] = {temp_ram[4*i+3], temp_ram[4*i+2], temp_ram[4*i+1], temp_ram[4*i]};
      	//if (i<100) //verify the data
      	//  $display("load address %h, data %h", i*4, u_boot_mem.u_mem.mem[i]);
      end
   end
 
 
             
  always #10 clk <= ~clk;
  
  initial
  begin
    clk = 0;
    rstn = 0;
    #1;
    rstn = 1;
  end                         
  
endmodule