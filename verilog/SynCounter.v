/*************Synchronous Counter*********/
module SynCounter(reset, clk, SynValue);
  input reset, clk;
	output reg[7:0] SynValue;
  always @(posedge clk)     
    if(reset)
			SynValue <= 8'b0;
		else
			SynValue <= SynValue + 1;	
endmodule

/*************Asynchronous Counter********/
module AsynCounter(reset, clk, AsynValue);
  input reset, clk;
  output reg[7:0] AsynValue;

  always @(posedge clk or reset)
    if(reset)
			AsynValue <= 8'b0;
		else
			AsynValue <= AsynValue + 1;	
endmodule

/*************Test bench********/
module TestBench;
  reg reset,clk;
  wire[7:0] SynValue;
  wire[7:0] ASynValue;
  
  SynCounter
        SYNCNT(reset, clk, SynValue);
  AsynCounter
        ASYNCNT(reset, clk, ASynValue);
        
  initial begin
    #0  clk = 1'b1;
        reset = 1'b0;
        
    #1  reset = 1'b1;
    #4  reset = 1'b0;
    #8  reset = 1'b1;
    #4  reset = 1'b0;
  end
  
  always #2 clk = ~clk;

endmodule

