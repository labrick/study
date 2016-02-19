String类中：

比较：

    boolean equals(String str):考虑大小写比较
    boolean equalsIgnoreCase(String str)：忽略大小写比较
    boolean regionMatchs(toffset, other, ooffset, len)：考虑大小写局部比较
    boolean regionMatchs(ignoreCase, toffset, other, ooffset, len)：忽略大小写局部比较，其中ignoreCase=true则忽略大小写
    boolean startsWith(String str)：判断字符串是否以指定的内容开始
    boolean endsWith(String str)：......
    int compareTo(String str)：判断字符串的大小（大于/等于/小于）

长度获取：

    int length()：获取字符串的长度

转换：

    toLowerCase()
    toUpperCase()

查找：

    indexOf(int ch)
    lastIndexOf(int ch)
    indexOf(String str)
    lastIndexOf(String str)
    indexOf(int ch, int startIndex)：从指定位置开始搜索
    lastIndexOf(int ch, int startIndex)：......
    indexOf(String str, int startIndex)：......
    lastIndexOf(String str, int startIndex)：......

截取：

    subString(start, end)

替换：

    replace(oldstr, newstr)
    trim()：去掉字符串两端的空格

分割：

    split(regex)：以regex为分隔符分割对象(regex也可以是正则表达式)，可用'|'增加为多个分隔符
            注意：如果regex为.和|时，应该采用\\.和\\|来取代
