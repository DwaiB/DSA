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
    DListNode(int capacity) : size(capacity), key(-1), value(-1), next(nullptr),prev(nullptr),count(0) {}
    DListNode(int x,int y,int size) : key(x), value(y), next(nullptr) ,prev(nullptr),count(1), size(size) {}
    DListNode(int x,int y, int count,int size, DListNode *prev,DListNode *next) : key(x), value(y), count(count+1), size(size), prev(prev), next(next){}
};

struct {
    void print(string msg, DListNode* head){
        DListNode* temp = head;
        cout << msg << endl;
        while(temp!=nullptr){
            cout << temp->key << ": " << temp->value <<endl;
            temp = temp-> next;
        }
        cout << endl;
    }
    void log(string msg){
        cout << "Log:: " << msg <<endl;
    }
} logger;
class LRUCache {
public:
    DListNode* head;
    unordered_map<int,DListNode*> hashmap;
    LRUCache(int capacity) {
        head = new DListNode(capacity);
    }
    
    int get(int key) {
        if(hashmap[key]){
            if(hashmap[key]->prev)
                SwapNodeFirst(hashmap[key]->prev->key);
            return hashmap[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(hashmap[key]){
            hashmap[key]->value=value;
            if(hashmap[key]){
                cout << "Calling Swap " << key <<endl;
                SwapNodeFirst(hashmap[key]->prev->key);
            }
             cout << "Calling Swap??" << endl;   
        }
        else{
            InsertNode(key,value);
        }
    }
    void SwapNodeFirst(int key){
        DListNode* ptr = hashmap[key];
        cout << ptr-> key << endl;
        logger.print("Swap to First",head);
        int value = ptr->value;
        if(ptr->next->next){
            ptr->next->prev = ptr;
            ptr->next = ptr->next->next;
        }
        else{
            ptr->next = nullptr;
        }
        
        hashmap[key] = nullptr;
        head = new DListNode(key,value,head->count,head->size,nullptr,head);
        hashmap[key] = head;
        
        
        
        

    }
    void InsertNode(int key,int value){
        if(head->count == head->size){
            DeleteLastNode();   
        }
        if(head->key == -1)
            head = new DListNode(key,value,head->size);
        else
            head = new DListNode(key,value,head->count,head->size,nullptr,head);

        hashmap[key] = head;
    }
    void DeleteLastNode(){
        DListNode* curr = head;
        DListNode* prev;
        while(curr->next!=nullptr){
            prev = curr;
            curr= curr->next;
        }
        head->count--;
        prev->next = nullptr;
        hashmap[curr->key] = nullptr;
    }
};


int main(){
    int capacity = 4,key=1,value = 1;

    LRUCache* obj = new LRUCache(capacity);
    obj->put(1,1);
    obj->put(2,2);
    obj->put(3,3);
    
    obj->put(4,4);
    obj->put(3,5);
    logger.print("Finished",obj->head);
    // for(auto it = obj->hashmap.begin();it!=obj->hashmap.end();it++){
        
    //     int param_1 = obj->get(it->second->key);
    //     if(param_1!=-1)
    //         cout << " Param: " << it->second->key << ":" << it->second->value << " = "<< param_1 << endl;
    // }
    cout <<"Finished "   <<endl;
    return 0;
}