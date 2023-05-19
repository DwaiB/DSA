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

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        priority_queue<pair<int,ListNode*>> maxh;
        ListNode* ptr = head;
        ListNode* res= nullptr;
        ListNode* temp;
        int it = 1,n=k;
        while(ptr!=nullptr){
            maxh.push({n*it,ptr});
            n--;
            if(n==0){
                n=k;
                it=maxh.top().first+1;
            }
            ptr = ptr->next;
        }
        while(maxh.size()>0){
            temp = maxh.top().second;
            cout << maxh.top().first << ": " << temp->val << endl;
            maxh.pop();
        }
        return head;
        
        if(n!=0 && n!=k){
            temp = maxh.top().second;
            temp->next = res;
            res= temp;
            maxh.pop();
            n++;
            temp = res;
            while(n<k){
                temp->next = maxh.top().second;
                temp = temp->next;
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
    while(temp!=nullptr){
        cout << temp->val << endl;
        temp = temp-> next;
    }
    return 0;
}