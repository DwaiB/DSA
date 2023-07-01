#include<bits/stdc++.h>
using namespace std;

class KthLargest {
public:
    priority_queue<int,vector<int>,greater<int>> minh;
    int pos;
    KthLargest(int k, vector<int>& nums) {
        int n = nums.size();
        for(int i=0;i<n;i++){
            minh.push(nums[i]);
            if(minh.size()>k){
                minh.pop();
            }
        }
        pos=k;
    }
    
    int add(int val) {
        minh.push(val);
        if(minh.size()>pos){
            minh.pop();
        }
        return minh.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */