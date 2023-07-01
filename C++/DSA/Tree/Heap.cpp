#include<bits/stdc++.h>
struct {
    void log(std::string message){
        std::cout<<message<<std::endl;
    }
} logger;
class Heap{
    public:
        int heap[50];
        int size;
        Heap(){
            size = 0;
        }
        void insertItem(int item){
            size = size+1;
            int ptr = size;
            while(ptr>1){
                int par = (int)ptr/2;
                if(item <= heap[par]){
                    heap[ptr] = item;
                    return;
                }
                heap[ptr] = heap[par]; 
                ptr = par;
            }
            heap[1] = item;
        }
        int deleteItem(){
            int item = heap[1];
            int last = heap[size];
            size = size-1;
            int ptr= 1,left = 2,right = 3;
            while(right <= size){
                if(last >= heap[left] && last >= heap[right]){
                    heap[ptr] = last;
                    return item;
                }
                if(heap[left] >= heap[right]){
                    heap[ptr] = heap[left];
                    ptr = left;
                }else{
                    heap[ptr] = heap[right];
                    ptr = right;
                }
                left = 2*ptr;
                right = left+1;
            }
            if(left == size && last < heap[left]){
                ptr = left;
            }
            heap[ptr] = last;
            return item;
        }
        void display(){
            std::cout << "Root " << heap[1] <<std::endl;
            for(int i=1;i*2<= size;i++){
                std::string s = "Left " + std::to_string(heap[i*2]) + " Right " + std::to_string(heap[i*2+1]); 
                logger.log(s);
            }
        }
};

int main(){
    Heap maxh;
    while(true){
        logger.log("Heap Structure");
        int choice;
        int val;
        logger.log("1. Insert\n2. Delete \n 3.Display \n  4. quit");
        std :: cin >> choice;
        switch(choice){
            case 1: logger.log("Enter Value: ");
                    std :: cin >> val;
                    maxh.insertItem(val); 
                    break;
            case 2: std:: cout << "Highest Item" << maxh.deleteItem() << std::endl; 
                    break;
            case 3: maxh.display();
                    break;
            default : return 0;
        }
    }
    return 0;
}