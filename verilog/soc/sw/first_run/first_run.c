#include "reg_define.h"
#define	TIME	90

int main (void)
{
	int i;

	// uart_init();
	uart_control->config.BAUD= 0;   	 				// ���ò�����9600
	uart_control->config.bitWidth = 8;					// ���ݿ���8
	uart_control->config.PARITY = 1;					// ��У��
	for(i=0;i<TIME;i++);


	// uart_send_byte(0x6C);				// ����UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x6C;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x9A);				// ����UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x9A;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x9A);				// �ǵ�UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x9A;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x4E);				// �ǵ�UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x4E;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x57);				// �ϵ�UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x57;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;

	// uart_send_byte(0x53);				// �ϵ�UTF8�ַ���8λ
	uart_control->tx_buffer.BUFFER = 0x53;
	uart_control->trans_control.SEND = 1;
	for(i=0;i<TIME;i++);
	uart_control->trans_control.SEND = 0;


	while(1);
	return 0;
}