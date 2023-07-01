#include<bits/stdc++.h>
#include "stack.h"
Stack::Stack(){
    head = new STACK;
    head->count =0;
    head->top = nullptr;
}
void Stack::push(int data){
    STACK_NODE* temptr = new STACK_NODE;
    temptr->dataptr = data;
    temptr->link = head->top;
    head->top = temptr;
    head->count++;
    
}
int Stack::pop(){
    int data;
    if(head->count >0){
        STACK_NODE* d_node = head->top;
        head->top = head->top->link;
        data = d_node->dataptr;
        head->count--;
    }
    return data;
}
int Stack::top(){
    int data;
    if(head->count >0){
        STACK_NODE* d_node = head->top;
        data = d_node->dataptr;
    }
    return data;
}
void Stack::print(){
    STACK_NODE* curr = head->top;
    while(curr!=nullptr){
        std::cout << curr->dataptr << " < ";
        curr = curr->link;
    }
    std::cout << std::endl;
}
