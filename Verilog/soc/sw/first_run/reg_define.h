/*
 * reg_define.h
 *
 * Created on: 2016-05-20
 * Author: yanan
 */

#ifndef REG_DEFINE_H_
#define REG_DEFINE_H_



#define TIMER_LOAD_REG  (*(int *)0x00008000)
#define TIMER_CUR_VALUE (*(int *)0x00008004)
#define TIMER_CTL_REG   (*(int *)0x00008008)

// uart_config
typedef struct
{
	int bitWidth:4;		// 5~8
	int BAUD:3;			// 0=9600; 1=115200; 2=34800; 3=4800
	int PARITY:1;		// 0=żУ��; 1=��У��
	int STOP:2;
	int RESERVE:22;
}config_t;

typedef struct
{
	int RECEIVE:1;
	int SEND:1;
	int RESERVE:30;
}trans_control_t;

typedef struct
{
	int BUFFER:32;
}tx_buffer_t;

typedef struct
{
	config_t 			config;
	trans_control_t		trans_control;
	tx_buffer_t			tx_buffer;
}uart_control_t;


#define uart_control	((uart_control_t *)0x0001a000)


#endif /* REG_DEFINE_H_ */
