#include<bits/stdc++.h>

using namespace std;
 struct DListNode {
    int key;
    int value;
    DListNode *next;
    DListNode *prev;
    DListNode() : key(0), value(0), next(nullptr),prev(nullptr) {}
    DListNode(int x,int y) : key(x), value(y), next(nullptr) ,prev(nullptr){}
    DListNode(int x,int y, DListNode *next,DListNode *prev) : key(x), value(y), next(next), prev(prev){}
 };
class LRUCache {
public:
    DListNode* head;
    unordered_map<int,DListNode*> hashmap;
    int size;
    LRUCache(int capacity) {
        size = capacity;
        head = nullptr;
    }
    
    int get(int key) {
        
        if(hashmap[key]){
            SwapNodeFirst(key);
            return hashmap[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        
        if(hashmap.size()==size && hashmap[key]==nullptr){
            DListNode* curr = head;
            while(curr->next!=nullptr){
                curr= curr->next;
            }
            hashmap[curr->value] = nullptr;
            InsertNode(key,value);
        }
        else if (hashmap.size()<size && hashmap[key]==nullptr){
            InsertNode(key,value);
        }
        else{
            hashmap[key]->value=value;
            SwapNodeFirst(key);
        }
    }
    void SwapNodeFirst(int key){
        DListNode* currptr;
        DListNode* prevptr;
        currptr = hashmap[key];
        prevptr = currptr->prev;
        prevptr->next = currptr->next;
        head->prev= currptr;
        currptr->next=head;
        currptr->prev=nullptr;
        head = currptr;
    }
    void InsertNode(int key,int value){
        DListNode* temp;
        temp->key = key;
        temp->value=value;
        temp->prev=nullptr;
        head->prev - temp;
        temp->next = head;
        head = temp;
        hashmap[key] = head;
    }
};

