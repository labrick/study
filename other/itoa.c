#include <stdio.h>

#define is_digit(c)	((c) >= '0' && (c) <= '9')  // 判断字符c是否为数字字符

int do_div(int* n,int base){
    int tmp = (*n)%base;
    *n = (*n)/base;
    return tmp;
}

// 该函数将字符数字串转换成整数。输入是数字串指针的指针，返回是结果数值。另外指针将前移
// 二重指针的好处是：二重指针const，一重指针可以变((*s)++)，节省一个变量？
static int skip_atoi(const char **s)
{
	int i=0;

	while (is_digit(**s))
		i = i*10 + *((*s)++) - '0';
	return i;
}

// 这里定义转换类型的各种符号常数
#define ZEROPAD	1		/* pad with zero */         /* 填充零 */
#define SIGN	2		/* unsigned/signed long */  /* 无符号/符号长整数 */
#define PLUS	4		/* show plus */             /* 显示加 */
#define SPACE	8		/* space if plus */         /* 如是加，则置空格 */
#define LEFT	16		/* left justified */        /* 左调整 */
#define SPECIAL	32		/* 0x */                    /* 0x */
#define SMALL	64		/* use 'abcdef' instead of 'ABCDEF' */  /* 使用小写字母 */

// 将整数转换为指定进制的字符串
// 输入：num-整数；base-进制；size-字符串长度；precision-数字长度(精度)；type-类型选项。
// 输出：str字符串指针
// type:64      32      16      8       4       2       1
//      SMALL   SPECIAL LEFT    SPACE   PLUS    SIGN    ZEROPAD
static char * number(char * str, int num, int base, int size, int precision
	,int type)
{
	char c,sign,tmp[36];
	const char *digits="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int i;

// 如果类型type指出用小写字母，则定义小写字母集
// 如果类型指出要做调整(靠左边界)，则屏蔽类型中的填零标志
// 如果进制基数小于2或大于36，则退出处理，也即本程序只能处理基数在2-32之间的数
	if (type&SMALL)     digits="0123456789abcdefghijklmnopqrstuvwxyz";
	if (type&LEFT)      type &= ~ZEROPAD;   // type最低位置零，不用填零
	if (base<2 || base>36)
		return 0;
// 如果类型指出要填零，则置字符变量c='0'，否则c等于空格字符
// 如果类型指出是带符号数并且数字num小于0，则置符号变量sign=负号，并使num取绝对值
// 否则如果类型指出是加号，则置sign=加号，否则若类型带空格标志则sign=空格。否则置0
	c = (type & ZEROPAD) ? '0' : ' ' ;      // 是填零还是填空格的填充字符
	if (type&SIGN && num<0) {               // 有符号数并且值小于0
		sign='-';
		num = -num;
	} else                                  // 无符号数或者有符号数大于等于0
		sign=(type&PLUS) ? '+' : ((type&SPACE) ? ' ' : 0);  // 这里的space什么作用？
// 若带符号，则宽度值减1。若类型指出是特殊转换，则对于十六进制宽度再减少2位(用于0x)
// 对于八进制宽度减1(用于八进制转换结果前放一个零)
	if (sign) size--;
	if (type&SPECIAL)
		if (base==16) size -= 2;
		else if (base==8) size--;
// 如果数值num为0，则临时字符串='0'；否则根据给定的基数将数值num转换成字符形式
	i=0;
	if (num==0)
		tmp[i++]='0';
	else while (num!=0)
		tmp[i++]=digits[do_div(&num,base)];  // 先拿到余数，后拿到商，顺序相反
// 若数值字符个数大于精度值，则精度值扩展为数字个数值
// 宽度值size减去用于存放数值字符的个数
	if (i>precision)    precision=i;
	size -= precision;      // 字符串宽度调整
// 从这里真正开始形成所需要的转换结果，并暂时放在字符串str中。
// 若类型中没有填零(ZEROPAD)和左靠齐(左调整)标志，则在str中首先填放剩余宽度值
// 指出的空格数。若需带符号位，则存入符号。
	if (!(type&(ZEROPAD+LEFT))) // 不需要左对齐，并且不需要填零
		while(size-->0)         // 用c代替了，整个if块是不是可以省略？
			*str++ = ' ';       // 前size位填写空格
	if (sign)
		*str++ = sign;          // 填写符号
// 若类型指出是特殊转换，则对八进制转换结果头一位放置一个'0'
// 而对于十六进制则存放'x0'
	if (type&SPECIAL)
		if (base==8)            // 八进制标志
			*str++ = '0';
		else if (base==16) {    // 十六进制标志
			*str++ = '0';
			*str++ = digits[33];    // 'X'或'x'
		}
// 若类型中没有左调整(左靠齐)标志，则在剩余宽度中存放c字符('0'或空格)，51行
	if (!(type&LEFT))           // 和上面的罗辑在一起，但代码不在一起，差评
		while(size-->0)
			*str++ = c;
// 此时i存有数值num的数字个数。若数字个数小于精度值，则str中放入(精度值-i)个'0'
	while(i<precision--)
		*str++ = '0';
// 将数值转换好的数字字符填入str中。共i个
	while(i-->0)
		*str++ = tmp[i];
// 若宽度值仍大于零，则表示类型标志中有左靠齐标志。则在剩余宽度中放入空格
	while(size-->0)
		*str++ = ' ';
	return str;     // 返回转换好的字符串
}

int main(int* argv ,int args){
    char str[11];
    int num = 1234567890, base = 16, size = 10, precision = 5, type = 1;
    number(str, num, base, size, precision, type);
    printf("%s\r\n", str);
    return 0;
}
