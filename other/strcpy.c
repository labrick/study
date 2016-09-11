#include <stdio.h>

char * strcpy(char * strDest, const char * strSrc) // 实现strSrc到strDest的复制
{
    if ((strDest == NULL) || (strSrc == NULL)) //判断参数strDest和strSrc的有效性
    {
        return NULL;
    }
    char *strDestCopy = strDest;                //保存目标字符串的首地址
    while ((*strDest++ = *strSrc++)!='\0');     //把strSrc字符串的内容复制到strDest下
    return strDestCopy;
}

int getStrLen(const char *strSrc)           //实现获取strSrc字符串的长度
{
    int len = 0;                            //保存长度
    while(*strSrc++ != '\0')                //循环直到遇见结束符'/0'为止
    {
        len++; 
    }
    
    return len;
}

int main()
{
    char strSrc[] = "Hello World!";     //要被复制的源字符串
    char strDest[20];                   //要复制到的目的字符数组
    int len = 0;                        //保存目的字符数组中字符串的长度
    
    len = getStrLen(strcpy(strDest, strSrc)); //链式表达式，先复制后计算长度
    printf("strDest: %s\n", strDest);
    printf("Length of strDest: %d\n", len);
    return 0;
}

