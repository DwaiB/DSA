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
    void log(unordered_map<int,DListNode*> hashmap){
        cout << "HASHMAP" << endl;
        for(const auto& it : hashmap){
      
            cout << it.first << ":" << it.second->value << endl;
    }
    }
} logger;


class LRUCache {
public:
    DListNode* head;
    unordered_map<int,DListNode*> hashmap;
    int size;
    LRUCache(int capacity) {
        size = capacity;
        head = nullptr;
         cout << "HASHMAP size " << hashmap.size() <<endl; 
    }
    
    int get(int key) {
        
        if(hashmap[key]){
            SwapNodeFirst(key);
            return hashmap[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        cout << "HASHMAP size in put " << hashmap.size() <<endl; 
       if(hashmap[key]){
            hashmap[key]->value=value;
            cout << "Calling Swap " << key <<endl;
            SwapNodeFirst(key);
            cout << "Calling Swap??" << endl;   
        }
        else{
            InsertNode(key,value);
        }
    }
    void SwapNodeFirst(int key){
        DListNode* ptr = hashmap[key];
        if(ptr == head) return;
        int value = ptr->value;
        if(ptr->next!=nullptr){
            ptr->next->prev = ptr->prev;
        }
        if(ptr->prev!=nullptr){
            ptr->prev->next = ptr->next;
        }
        ptr->prev = nullptr;
        ptr->next = head;
        if(head!=nullptr){
            head->prev = ptr;
        }
        head = ptr;
        cout << "HASHMAP size before swap " << hashmap.size() <<endl;
        hashmap[key] = head;
        
    }
    void InsertNode(int key,int value){
        logger.print("Insert in ",head);
        if(hashmap.size() > size){
            DeleteLastNode();   
        }
        DListNode *temp = new DListNode(key,value);
        temp->next = head;
        temp->prev = nullptr;
        if(head!=nullptr){
            head->prev = temp;
        }
        head = temp;
        cout << "HASHMAP size before insert " << hashmap.size() <<endl; 
        hashmap[key] = head;
        cout << "HASHMAP size after insert   " << hashmap.size() <<endl;
    }
    void DeleteLastNode(){
        DListNode* curr = head;
        
        while(curr->next!=nullptr && curr->next->next!=nullptr){
            curr= curr->next;
        }if(curr->next!=nullptr){
            cout << " Deleting " << curr->next->key << endl;
            hashmap.erase(curr->next->key);
            curr->next = nullptr;
        }
        else if (curr == head){
            // hashmap.erase(curr->key);
            head = nullptr;
        }
        else{
        }
        logger.log(hashmap);

        
    }
};


int main(){
    int capacity = 1,key=1,value = 1;

    LRUCache* obj = new LRUCache(capacity);
    obj->put(2,1);
    int a = obj->get(2);
    obj->put(3,2);
    a = obj->get(2);
    a= obj->get(3);
    logger.print("Finished",obj->head);
    logger.log(obj->hashmap);
    cout <<"Finished "   <<endl;
    return 0;
}