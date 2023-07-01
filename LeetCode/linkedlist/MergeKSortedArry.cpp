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

 typedef pair<int,ListNode*> p;
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<p> maxh;
        int n = lists.size()-1;
        while(n>=0){
            ListNode* head = lists[n];
            while(head!=nullptr){
                maxh.push({head->val,head});
                head = head->next;
            }
            n--;
        }
        ListNode* res = nullptr;
        ListNode* temp;
        while(maxh.size()>0){
            temp = maxh.top().second;
            temp->next = res;
            res = temp;
            maxh.pop();
        }
        return res;
    }
};