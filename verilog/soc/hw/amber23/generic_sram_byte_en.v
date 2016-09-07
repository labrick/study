//////////////////////////////////////////////////////////////////
//                                                              //
//  Generic Library SRAM with per byte write enable             //
//                                                              //
//  This file is part of the Amber project                      //
//  http://www.opencores.org/project,amber                      //
//                                                              //
//  Description                                                 //
//  Configurable depth and width. The DATA_WIDTH must be a      //
//  multiple of 8.                                              //
//                                                              //
//  Author(s):                                                  //
//      - Conor Santifort, csantifort.amber@gmail.com           //
//                                                              //
//////////////////////////////////////////////////////////////////
//                                                              //
// Copyright (C) 2010 Authors and OPENCORES.ORG                 //
//                                                              //
// This source file may be used and distributed without         //
// restriction provided that this copyright statement is not    //
// removed from the file and that any derivative work contains  //
// the original copyright notice and the associated disclaimer. //
//                                                              //
// This source file is free software; you can redistribute it   //
// and/or modify it under the terms of the GNU Lesser General   //
// Public License as published by the Free Software Foundation; //
// either version 2.1 of the License, or (at your option) any   //
// later version.                                               //
//                                                              //
// This source is distributed in the hope that it will be       //
// useful, but WITHOUT ANY WARRANTY; without even the implied   //
// warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR      //
// PURPOSE.  See the GNU Lesser General Public License for more //
// details.                                                     //
//                                                              //
// You should have received a copy of the GNU Lesser General    //
// Public License along with this source; if not, download it   //
// from http://www.opencores.org/lgpl.shtml                     //
//                                                              //
//////////////////////////////////////////////////////////////////


module generic_sram_byte_en
#(
parameter DATA_WIDTH    = 128,
parameter ADDRESS_WIDTH = 7
)

(
input                           i_clk,
input      [DATA_WIDTH-1:0]     i_write_data,
input                           i_write_enable,
input      [ADDRESS_WIDTH-1:0]  i_address,
input      [DATA_WIDTH/8-1:0]   i_byte_enable,
output reg [DATA_WIDTH-1:0]     o_read_data
    );                                                     

reg [DATA_WIDTH-1:0]   mem  [0:2**ADDRESS_WIDTH-1];
integer i;

always @(posedge i_clk)
    begin
    // read
    o_read_data <= i_write_enable ? {DATA_WIDTH{1'd0}} : mem[i_address];

    // write
    if (i_write_enable)
        for (i=0;i<DATA_WIDTH/8;i=i+1)
            begin
            mem[i_address][i*8+0] <= i_byte_enable[i] ? i_write_data[i*8+0] : mem[i_address][i*8+0] ;
            mem[i_address][i*8+1] <= i_byte_enable[i] ? i_write_data[i*8+1] : mem[i_address][i*8+1] ;
            mem[i_address][i*8+2] <= i_byte_enable[i] ? i_write_data[i*8+2] : mem[i_address][i*8+2] ;
            mem[i_address][i*8+3] <= i_byte_enable[i] ? i_write_data[i*8+3] : mem[i_address][i*8+3] ;
            mem[i_address][i*8+4] <= i_byte_enable[i] ? i_write_data[i*8+4] : mem[i_address][i*8+4] ;
            mem[i_address][i*8+5] <= i_byte_enable[i] ? i_write_data[i*8+5] : mem[i_address][i*8+5] ;
            mem[i_address][i*8+6] <= i_byte_enable[i] ? i_write_data[i*8+6] : mem[i_address][i*8+6] ;
            mem[i_address][i*8+7] <= i_byte_enable[i] ? i_write_data[i*8+7] : mem[i_address][i*8+7] ;
            end                                                 
    end

//`ifdef GENERIC_RAM_LOG
//module ram_monitor(i_clk, i_address, i_write_enable, i_byte_enable, i_write_data, i_read_data);
//#(
//parameter ADDRESS_WIDTH = 7
//)
//input i_clk, i_write_enable;
//input [3:0]i_byte_enable;
//input [ADDRESS_WIDTH-1:0]i_address;
//input [31:0]i_write_data;
//input [31:0]i_read_data;
//
//
//  always @(posedge i_clk) begin
//     if (i_write_enable)
//       case(i_byte_enable[3:0])
//       	4'b0001:   $display("  write address %h, 1 bytes, data %h", i_address, i_write_data[0]);
//       	4'b0010:   $display("  write address %h, 1 bytes, data %h", i_address, i_write_data[1]);
//       	4'b0100:   $display("  write address %h, 1 bytes, data %h", i_address, i_write_data[2]);
//       	4'b1000:   $display("  write address %h, 1 bytes, data %h", i_address, i_write_data[3]);
//    	  4'b0011:   $display("  write address %h, 2 bytes, data %h", i_address, i_write_data[1:0]);
//       	4'b1100:   $display("  write address %h, 2 bytes, data %h", i_address, i_write_data[3:2]);
//        4'b1111:   $display("  write address %h, 4 bytes, data %h", i_address, i_write_data[3:0]);
//       endcase
//       
//     if (i_read_enable)
//       
//       
//       
//`endif       

endmodule
