//module timer (baud,nextbit, reset, clk);
module timer (baud,nextbit, reset, clk);
input clk, reset;
input [2:0] baud;
output nextbit;
wire [7:0] baud_counter;
reg [19:0]counter;

assign baud_counter = (baud==3'b000)?8'b01101000:                   //9600
								      (baud==3'b001)?8'b00001000:                   //115200
								      (baud==3'b010)?8'b00011010:                   //38400
								      (baud==3'b011)?8'b11010000:8'b01101000;       // 4800

always @(posedge clk or posedge reset)
begin
	if (reset)
		counter <= 'h0;
	else if (counter == baud_counter)
		counter <= 'h0;
	else
	  counter <= counter + 1;
end

assign nextbit = (counter == baud_counter);

endmodule