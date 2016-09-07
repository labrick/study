module top(clk, rstn);

input clk, rstn;
					
wire hready;
wire [1:0]hresp;
wire [31:0]hrdata;
wire irq, fiq;
wire [31:0]haddr;
wire [31:0]hwdata;
wire [1:0]htrans;
wire [2:0]hburst;
wire [1:0]hsize;
wire hwrite;
					
a23_ahb U_a23(
				.hclk	(clk), 
				.hresetn(rstn), 
				.haddr(haddr), 
				.htrans(htrans), 
				.hburst(hburst), 
				.hsize(hsize), 
				.hwrite(hwrite), 
				.hwdata(hwdata), 
				.hrdata(hrdata), 
				.hready(hready), 
				.hresp(2'b00), 
				.irq(1'b0), 
				.fiq(1'b0)
				);					      

wire [31:0]paddr, pwdata, prdata_s0, prdata_s10;// 
	
apb U_apb(
               .hclk(clk), 
               .hresetn(rstn),
               .haddr(haddr), 
               .hready(1'b1), 
               .hsel(htrans[1]),
               .htrans(htrans), 
               .hwrite(hwrite),
               .hsize({1'b0, hsize}), 
               .hburst(hburst),
               .hresp(hresp), 
               .hready_resp(hready),
               .hwdata(hwdata), 
               .hrdata(hrdata),
               .paddr(paddr), 
               .penable(penable), 
               .pwrite(pwrite),
               .pwdata(pwdata),
               .pclk_en(1'b1),
               .psel_s15(),
               .psel_s14(),
               .psel_s13(),
               .psel_s12(),
               .psel_s11(),
               .psel_s10(psel_s10),
               .psel_s9(),
               .psel_s8(),
               .psel_s7(),
               .psel_s6(),
               .psel_s5(),
               .psel_s4(),
               .psel_s3(),
               .psel_s2(),
               .psel_s1(psel_s1),
               .psel_s0(psel_s0),
               .prdata_s15(32'hdeadbeaf),
               .prdata_s14(32'hdeadbeaf),
               .prdata_s13(32'hdeadbeaf),
               .prdata_s12(32'hdeadbeaf),
               .prdata_s11(32'hdeadbeaf),
               .prdata_s10(prdata_s10),
               .prdata_s9(32'hdeadbeaf),
               .prdata_s8(32'hdeadbeaf),
               .prdata_s7(32'hdeadbeaf),
               .prdata_s6(32'hdeadbeaf),
               .prdata_s5(32'hdeadbeaf),
               .prdata_s4(32'hdeadbeaf),
               .prdata_s3(32'hdeadbeaf),
               .prdata_s2(32'hdeadbeaf),
               .prdata_s1(prdata_s1),//prdata_s1
               .prdata_s0(prdata_s0)//prdata_s0
               );
    
esram_apb U_esram(
 								.pclk(clk), 
 								.psel(psel_s0), 
 								.penable(penable), 
 								.pwrite(pwrite), 
 								.pwdata(pwdata), 
 								.prdata(prdata_s0), 
 								.paddr(paddr)
 								);


timer_apb U_timer_apb(
  						.paddr	(paddr[15:0]),
  						.pclk		(clk				),
  						.penable(penable		),
  						.prdata	(prdata_s1	),	
  						.presetn(rstn				),
  						.psel		(psel_s1		),
  						.pwdata	(pwdata			),
  						.pwrite	(pwrite			)
						);
	uart_tx U_uart(
					.paddr(paddr), 
					.pclk(clk), 
					.penable(penable),  
					.prdata(prdata_s10), 
					.presetn(rstn), 
					.psel(psel_s10),// psel_s10
					.pwdata(pwdata), 
					.pwrite(pwrite));


endmodule