module parity_gen #(parameter DSIZE = 8) (bitWidth,data, oddeven, parity);
//module parity_gen #(parameter DSIZE = 8) (bitWidth,data, oddeven, parity);
input [DSIZE - 1:0] data;
input oddeven;
output parity;
input [3:0] bitWidth;
//assign parity = (^data) ^ oddeven;
assign parity = (bitWidth==4'd8)?(^data) ^ oddeven:
								 (bitWidth==4'd7)?{(^data[6:0]) ^ oddeven}:
								 (bitWidth==4'd6)?{(^data[6:0]) ^ oddeven}:
								 (bitWidth==4'd5)?{(^data[6:0]) ^ oddeven}:{(^data[7:0]) ^ oddeven};

//{(^data[7:0]) ^ oddeven}
endmodule