#include<bits/stdc++.h>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
struct {
    void log(ListNode* head){
        ListNode* temp = head;
        while(temp!=NULL){
            cout << temp->val <<",";
            temp = temp->next;
        }
        cout<<"\n";
    }
} logger;
class Solution {
public:
    ListNode* reverseKList(ListNode*head, int k){
        ListNode* temp = head; ListNode* next = nullptr;ListNode* prev = nullptr;
        int i=0;
        while(temp->next != nullptr){
            if(i==k) break;
            i++;
            next = temp->next;
            temp->next = prev;
            prev = temp;
            temp = next;
        }
        return prev;        
    }
    ListNode* fill(ListNode* final,ListNode* pres){
        ListNode* temp = final;
        while(temp->next!=nullptr){
            temp = temp->next;
        }
        temp->next = pres;
        return temp;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* temp=head;ListNode* curr = head;ListNode* pres = nullptr;
        int i=0;
        while(temp->next != nullptr){
            
            if(i==k){
                pres = reverseKList(curr,k);
                curr = temp;
            }
        }
        return reverseKList(head,k);
    }
    
};


int main(){
    ListNode* head = new ListNode();
    ListNode* temp = head;
    ListNode* rev;
    for(int i=1;i<=5;i++){
        temp->val = i;
        temp->next = new ListNode();
        temp = temp->next;
    }
    Solution sol;
    rev = sol.reverseKList(head,2);
    ListNode* res = sol.fill(head,rev);
    // logger.log(head);
    logger.log(res);
    // logger.log(rev);
    return 0;
}