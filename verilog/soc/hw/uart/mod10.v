module mod10 (bitWidth,clk, reset, increment, count10);
input clk, reset, increment;
input [3:0] bitWidth; 
output count10;

wire [3:0] ns, qPlus1;
reg [3:0]q;

assign qPlus1 = (q == bitWidth+2) ? 0 : q+1; // Input forming logic

assign ns = (reset) ? 0 : 
						(increment) ? qPlus1 : q; 
						
always @(posedge clk or posedge reset)
begin
	if (reset)
		q <= 4'b0;
	else
		q <= ns;
end		
	

assign count10 = increment & (q == 9); // Rollover logic

endmodule