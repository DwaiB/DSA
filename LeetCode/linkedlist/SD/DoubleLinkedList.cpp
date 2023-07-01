#include<bits/stdc++.h>
using namespace std;
struct DListNode {
    int key;
    int value;
    int size;
    int count;
    DListNode *next;
    DListNode *prev;
    DListNode() : key(0), value(0), next(nullptr),prev(nullptr), count(0){}
    DListNode(int capacity) : size(capacity), key(0), value(0), next(nullptr),prev(nullptr),count(0) {}
    DListNode(int x,int y) : key(x), value(y), next(nullptr) ,prev(nullptr) {
        count++;
    }
    DListNode(int x,int y, DListNode *next,DListNode *prev) : key(x), value(y), next(next), prev(prev){
        count ++;
    }
};
struct {
    void print(DListNode* head){
        DListNode* temp = head;
        while(temp->next!=nullptr){
            cout << temp->key << " : " << temp->value <<endl;
            temp = temp-> next;
        }
        cout << endl;
    }
    void log(string msg){
        cout << "Log:: " << msg <<endl;
    }
    void log(int i,int key,int value){
        if(i==-1){
            cout  << "Log:: List Overflow" << endl; 
        }
        cout << "Log::  Index: " << i << " { " << key << ": " << value << " }" << endl;
    }
} logger;
class DoubleLinkedList{
public:
    DListNode* head;
    DoubleLinkedList(int capacity){
        head = new DListNode(capacity);
    }
    void show(){
        DListNode* itr = head;
        int i=0;
        while(itr!=nullptr){
            if(i==head->size) break;
            cout << itr->key << " : " << itr->value <<endl;
            itr = itr->next;
            i++;
        }
    }
    DListNode* get(int k){
        if(k<=head->count){
            DListNode* itr;
            int i;
            for(i=1,itr=head;i<k;i++,itr = itr->next);
            return itr;
        }
        return nullptr;
    }
    void put(int k, int key,int value){
        if(head->count==0){
            head->key=key;
            head->value=value;
            head->count= head->count+1;
            return;
        }
        DListNode* itr= head;
        int i;
        if(k <= head->size){
            
            for(i=1,itr=head;i<k-1;i++){
                if (itr->next==nullptr) break;
                itr = itr->next;
            };
            if(itr->next!=nullptr){
                itr->next= new DListNode(key,value,itr->next,itr);
            }
            else{
                itr->next = new DListNode(key,value,nullptr,itr);
            }
            logger.log(i,key,value);
        }
        else{
            logger.log(-1,key,value);
        }
        
    }
};
int main(){

    // cout << "capacity " << capacity << endl;
    // DListNode* head = ;
    // DListNode* ptr;
    // for(int i = 1;i<=5;i++){
    //     if(head == nullptr){
    //         head = new DListNode(i,i,nullptr,nullptr);
    //         ptr = head;
    //         continue;
    //     }
    //     ptr->next = new DListNode(i,i,nullptr,ptr);
    //     ptr = ptr->next;
    // }
    // logger.print(head);
    // logger.log("Getting index 2");
    // DListNode* item = logger.get(2,head);
    // cout << item->key << " : " << item->value << endl;
    // return 0;





    int capacity = 5;
    DoubleLinkedList* linklist = new DoubleLinkedList(capacity);
    linklist->show();
    cout << "Side of List: " << linklist->head->size << endl;
    linklist->put(1,1,1);
    linklist->put(2,2,2);
    linklist->put(3,3,3);
    linklist->put(4,4,4);
    linklist->put(5,5,5);
    linklist->show();
    linklist->put(6,6,6);
    linklist->put(4,8,8);
    linklist->show();
    return 0;
}



