#include <bits/stdc++.h>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *insertionSortList(ListNode *head)
    {
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode *sList = new ListNode(head->val);
        ListNode *curr = head->next;
        ListNode *prev = sList;
        ListNode *temp,*next;
        while(curr!= nullptr){
            next = curr->next;

            if(prev->val >= curr->val) prev = sList;
            while(prev->next!=nullptr && prev->next->val < curr->val){
                prev = prev->next;
            }
            curr->next = prev->next;
            prev->next = curr;
            prev = sList;
            curr = next;
        }
        return sList;
    }
};

int main()
{
    auto start = std::chrono::system_clock::now();
    Solution sol;
    ListNode *head = new ListNode(-1,
                                  new ListNode(6,
                                               new ListNode(3,
                                                            new ListNode(4,
                                                                         new ListNode(5, nullptr)))));
    ListNode *temp;
    temp = sol.insertionSortList(head);
    auto end = std::chrono::system_clock::now();

    std::chrono::duration<double> elapsed_seconds = end - start;
    std::time_t end_time = std::chrono::system_clock::to_time_t(end);

    std::cout << "finished computation at " << std::ctime(&end_time)
              << "elapsed time: " << elapsed_seconds.count() << "s\n";
    while (temp != nullptr)
    {
        cout << temp->val << endl;
        temp = temp->next;
    }
    return 0;
}