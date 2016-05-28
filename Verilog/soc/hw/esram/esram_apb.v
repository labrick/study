//`timescale 1 ns/10 ps
module esram_apb(pclk, psel, penable, pwrite, pwdata, prdata, paddr);

 input pclk, psel, penable, pwrite;
 input [31:0]paddr, pwdata;
 output [31:0]prdata;


 wire [3:0]wen;
 wire [14:0]a;

 assign cen = !psel;
 assign wen = {4{!(penable & pwrite)}} ;
 assign oen = !(psel & penable & !pwrite);
 assign a = paddr[14:0]; 
  

  RA1SH32K U_RAM(
   .Q(prdata),
   .CLK(pclk),
   .CEN(cen),
   .WEN(wen),
   .A(a[14:2]),
   .D(pwdata),
   .OEN(oen)
	);           

        
endmodule

            
                      
