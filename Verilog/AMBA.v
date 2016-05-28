module GLUE_LOGIC(
                  PCLK,         // 时钟
                  PRESETn,      // 复位
                  PSEL,         // 选择（选择啥？）
                  PADDR,        // CPU发出的地址
                  PWRITE,       // 1=写，0=读
                  PENABLE,      // 使能
                  PRDATA,       // 总线输出的数据(O)
                  RdData,       // 总线获取的数据
                  RdClk,        // 读时钟(O)
                  RdEn,         // 读使能(O)
                  Empty,        // FIFO空标志
                  );
  input PCLK;
  input PRESETn;
  input PSEL;
  input [15:0] PADDR;
  input PWRITE;
  input PENABLE;
  input [7:0] RdData;
  input Empty;
  output [31:0] PRDATA;
  output RdClk;
  output RdEn;

  reg [31:0] PRDATA;
  
  integer counter;                      // 记录第几次都得8bit
  reg [3:0] write_ptr;                  // AMBA缓冲区写指针
  reg [7:0] mem[3:0];                   // 四个FIFO单元组成一个PRDATA
  reg mem_WrEn;                         // AMBA是否可写？
  wire mem_full;                        // 判断是否构成四个字节单元
  wire mem_empty;                       // 总线缓冲为空？
  
  // 要RdClk干嘛？
  always@(posedge RdClk or negedge PRESETn)     // RST为0则初始化
  begin
    if(!PRESETn)
    begin
      write_ptr<=0;
      counter<=0;
      mem[0]=8'b0;
      mem[1]=8'b0;
      mem[2]=8'b0;
      mem[3]=8'b0;
    end  
  end

  assign mem_full=(counter >= 3);
  assign mem_empty=(counter == 0);  
  assign RdEn=(~Empty && ~mem_full);   // FIFO非空，AMBA未满则可读

  always@(posedge RdClk)            // 读FIFO到AMBA
  begin 
    mem_WrEn<=RdEn;                 // FIFO读使能即是AMBA写使能
    if(mem_WrEn)
    begin
      mem[write_ptr]<=RdData;
      counter<=counter+1;
      write_ptr<=write_ptr+1;
    end
    else
    begin
      write_ptr<=1'b0;
    end  
  end
       
  always@(posedge PCLK)     // AMBA根据地址输出
  begin
    if(PSEL && !PWRITE)     // CPU给出写使能，也就相当于AMBA的输出
    begin
      if(!PENABLE)
        begin
        case(PADDR[7:2])
          6'b000011:
          begin
              PRDATA<= {mem[3],mem[2],mem[1],mem[0]};
              counter<=0;
          end
          default:
          begin
            PRDATA <= 32'bx;
          end
        endcase
        end
      else
      begin
        PRDATA <= 32'bx;
      end
    end
  end

endmodule     
