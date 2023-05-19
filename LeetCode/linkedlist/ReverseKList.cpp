#include<bits/stdc++.h>
using namespace std;

 //Definition for singly-linked list.
 struct ListNode {
   int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 struct {
    void print(ListNode* head){
        ListNode* temp = head;
        while(temp!=nullptr){
        cout << temp->val << " -- " ;
        temp = temp-> next;
    }
     cout << endl;
    }
 } logger;

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == nullptr || head-> next == nullptr) return head;
        priority_queue<pair<double,ListNode*>> maxh;
        ListNode* ptr = head;
        ListNode* res= nullptr;
        ListNode* temp;
        double it = 1,n=k;
        while(ptr!=nullptr){
            maxh.push({n*it,ptr});
            n--;
            if(n==0){
                n=k;
                it=maxh.top().first+1;
            }
            ptr = ptr->next;
        }
        
        if(n!=0 && n<=k){
            temp = maxh.top().second;
            temp->next = res;
            res= temp;
            maxh.pop();
            n++;
            temp = res;
            while(n<k){
                temp->next = maxh.top().second;
                temp = temp->next;
                maxh.pop();
                n++;
            }
        }
        while(maxh.size()>0){
            temp = maxh.top().second;
            temp->next = res;
            res = temp;
            maxh.pop();
        }
        return res;
    }
};


int main(){
    Solution sol;
    ListNode* head = new ListNode(1);
    ListNode* temp = head;
    int n = 5,i=2;
    while(i <= n){
        temp-> next = new ListNode(i);
        temp = temp->next;
        i++;
    }
    temp-> next = nullptr;
    temp = sol.reverseKGroup(head,3);
    logger.print(temp);
    return 0;
}
