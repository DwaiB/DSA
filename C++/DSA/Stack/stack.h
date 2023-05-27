#ifndef Stack_h
#define Stack_h
#endif

typedef struct node{
    int dataptr;
    node* link;
}STACK_NODE;

typedef struct {
    STACK_NODE* top;
    int count;
} STACK;

class Stack{
    public:
        STACK* head;
        Stack();
        void push(int data);
        int pop();
        int top();
        void print();
};