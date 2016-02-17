#include <stdio.h>
#include "sum.h"

extern int sum(int a, int b);

int main()
{
	printf("4+5=%d\n",sum(4,5));
	return 0;
}
