module ShiftReg #(parameter DSIZE = 8) (bitWidth,clk, reset, din, parity, load, shift, dout);  //传入进来的还是8位数据
input clk, reset, parity, load, shift;
input [DSIZE - 1:0] din;
input [3:0] bitWidth; 
output dout;

wire [DSIZE + 1:0] ns;
reg [DSIZE + 1:0] q;

assign ns = reset ? (1<<DSIZE + 2) - 1  :
						load ? ((bitWidth==4'd8)? {parity, din[7 : 0], 1'b0} :
								(bitWidth==4'd7)? {1'b1,parity, din[6 : 0], 1'b0} :
								(bitWidth==4'd6)? {2'b11,parity, din[5 : 0], 1'b0} :
								(bitWidth==4'd5)? {3'b111,parity, din[4 : 0], 1'b0} : {parity, din[7 : 0], 1'b0} ):
						shift ? ((bitWidth==4'd8)?{1'b1, q[9:1]}:
								 (bitWidth==4'd7)?{2'b11, q[8:1]}:
								 (bitWidth==4'd6)?{3'b111, q[7:1]}:
								 (bitWidth==4'd5)?{4'b1111, q[6:1]}:{1'b1, q[9:1]}) :
						q;
						
always @(posedge clk or posedge reset)
begin
	if (reset)
		q <= (1<<DSIZE + 2) - 1;
	else begin
		case(bitWidth) 
			4'd8:q <= ns[9 : 0];
			4'd7:q <= ns[8 : 0];
			4'd6:q <= ns[7 : 0];
			4'd5:q <= ns[6 : 0];
			default: q <= ns[9 : 0];
		endcase	
	end
end

assign dout = q[0];

endmodule