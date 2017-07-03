// queue.h -- interface for a queue
#ifndef QUEUE_H_
#define QUEUE_H_
// This queue will contain Custormer items
class Customer
{
private:
    long arrive;        // arrival time for customer
    int processtime;    // processing time for customer
public:
    Customer() { arrive = processtime = 0; }
    
    void set(long when);
    long when() const { return arrive; }
    int ptime() const { return processtime; }
};

typedef Customer Item;

class Queue
{
private:
    // class scope definitions
    // Node is a nested structure definition local to this c
    struct Node { Item item; struct Node * next; };
    enum { Q_SIZE = 10 };

    // private class members
    Node * front;       // pointer to front of Queue
    Node * rear;        // pointer to rear of Queue
    int items;          // current number of items in Queue
    const int qsize;    // maxium number of items in Queue
    // preemptive definitions to prevent public copying
    // 私有化复制构造函数和赋值运算符
    Queue(const Queue & q) : qsize(0){}
    Queue & operator=(const Queue & q){ return *this; }

public:
    Queue(int qs = Q_SIZE);     // create queue with a qs limit
    ~Queue();
    bool isempty() const;
    bool isfull() const;
    int queuecount() const;
    bool enqueue(const Item &item);     // add item to end
    bool dequeue(Item &item);           // remove item from front
};
#endif