module fsm(clk, reset, send, nextbit, count10, load, busy, resetcounter, resettimer, shift, increment);

input clk, reset, send, nextbit, count10;
output load, busy, resetcounter, resettimer, shift, increment;


parameter IDLE 	= 3'B000;
parameter LOAD 	= 3'B001;
parameter COUNT = 3'B010;
parameter SHIFT = 3'B011;
parameter WAIT 	= 3'B100;

reg [2:0]cur_st,nxt_st;
reg load, busy, resetcounter, resettimer, shift, increment;


always @(posedge clk or posedge reset)
begin
	if (reset)
	  cur_st <= IDLE;
	else 
		cur_st <= nxt_st;
end

always @*
begin
	nxt_st = cur_st;
	case(cur_st)
		IDLE: //000
		  if (send)
		  	nxt_st = LOAD;
		LOAD: //001
		    nxt_st = COUNT;
		COUNT: //010
		  if (nextbit)
		    nxt_st = SHIFT;
		SHIFT: //011
		  if (count10)
		  	nxt_st = WAIT;
		 	else
		 		nxt_st = COUNT;
		WAIT: //100
		  if (!send)
		  	nxt_st = IDLE;
		default:
		    nxt_st = IDLE;
	endcase
end

always @*
begin
	case(cur_st)
		IDLE:
			begin
				load = 1'b0;
				busy = 1'b0;
				resetcounter = 1'b1;
				resettimer = 1'b1;
				shift = 1'b0;
				increment = 1'b0;
			end
		LOAD:
		  begin
				load = 1'b1;
				busy = 1'b1;
				resetcounter = 1'b0;
				resettimer = 1'b0;
				shift = 1'b0;
				increment = 1'b0;
			end
		COUNT:
		  begin
				load = 1'b0;
				busy = 1'b1;
				resetcounter = 1'b0;
				resettimer = 1'b0;
				shift = 1'b0;
				increment = 1'b0;
			end		
		SHIFT:
		  begin
				load = 1'b0;
				busy = 1'b1;
				resetcounter = 1'b0;
				resettimer = 1'b0;
				shift = 1'b1;
				increment = 1'b1;
			end		
		WAIT:
		  begin
				load = 1'b0;
				busy = 1'b0;
				resetcounter = 1'b1;
				resettimer = 1'b1;
				shift = 1'b0;
				increment = 1'b0;
			end
		default:
		  begin
				load = 1'b0;
				busy = 1'b0;
				resetcounter = 1'b1;
				resettimer = 1'b1;
				shift = 1'b0;
				increment = 1'b0;
			end
		endcase
end		    
	



endmodule