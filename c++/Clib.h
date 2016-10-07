//: C04:CLib.h
// Header file for a C-like library
// An array-like entity created at runtime
typedef struct CStashTag
{
    int size;
    int quantity;
    int next;
    unsigned char* storage;
}CStash;

void initialize(CStash* s, int size);
int add(CStash* s, const void* element);
void inflate(CStash* s, int increase);
int count(CStash* s);  // 计算CStash里的数据有多少个，
void* fetch(CStash* s, int index);  //取指针里的数，
void cleanup(CStash* s);  // 清除，把分配的内存释放，
///:~
