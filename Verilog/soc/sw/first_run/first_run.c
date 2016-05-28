#include "reg_define.h"
#define	TIME	90

int main (void)
{
	int i;

	// uart_init();
	uart_control->config.BAUD= 0;   	 				// 配置波特率9600
	uart_control->config.bitWidth = 8;					// 数据宽度8
	uart_control->config.PARITY = 1;					// 奇校验
	for(i=0;i<TIME;i++);


	// uart_send_byte(0x6C);				// 马的UTF8字符低8位
	uart_control->tx_buffer.BUFFER = 0x6C;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x9A);				// 马的UTF8字符高8位
	uart_control->tx_buffer.BUFFER = 0x9A;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x9A);				// 亚的UTF8字符低8位
	uart_control->tx_buffer.BUFFER = 0x9A;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x4E);				// 亚的UTF8字符高8位
	uart_control->tx_buffer.BUFFER = 0x4E;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x57);				// 南的UTF8字符低8位
	uart_control->tx_buffer.BUFFER = 0x57;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x53);				// 南的UTF8字符高8位
	uart_control->tx_buffer.BUFFER = 0x53;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;


	while(1);
	return 0;
}
