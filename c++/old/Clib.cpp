//: C04:CLib.cpp {O}
// Implementation of example C-like library
// Declare structure and functions:
#include "Clib.h"
#include <cstdlib>
#include <cassert> // 这个是断言的头文件，

const int increment = 100;

void initialize(CStash* s, int sz)
{
    s->size = sz;
    s->quantity = 0;
    s->next = 0;
    s->storage = 0;
}

int add(CStash* s, const void* element)
{
    if (s->next >= s->quantity)
        inflate(s, increment);
    int startBytes = s->next *s->size;
    unsigned char *e = (unsigned char*)element;
    for (int i = 0; i < s->size; i++)
        s->storage[startBytes + i] = e[i];
    s->next++;
    return (s->next - 1); // 返回的是位置，
}

void inflate(CStash* s, int increase)
{
    assert(increase > 0);
    int newQuantity = s->quantity + increase;
    int newBytes = newQuantity * s->size;
    int oldBytes = s->quantity * s->size;
    unsigned char* b = (unsigned char*)malloc(newBytes);
    for (int i = 0; i < oldBytes; i++)
        b[i] = s->storage[i];
    free(s->storage);
    s->storage = b;
    s->quantity = newQuantity;
}

int count(CStash* s)
{
    return s->next;
}

void* fetch(CStash* s, int index)
{
    assert(0 <= index);
    if (index >= s->next)  // 如果这个索引超出最大的索引就返回0，就结束了，
        return 0;
    return &(s->storage[index * s->size]);  //返回的是一个地址，
}

void cleanup(CStash* s)
{
    if (s->storage != 0)
    {
        free(s->storage);
    }
}

