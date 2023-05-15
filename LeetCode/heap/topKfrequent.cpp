#include<bits/stdc++.h>
using namespace std;
typedef pair<int, int> pr;
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        int n = nums.size();
        for(int i=0;i<n;i++){
            mp[nums[i]]++;
        }
        priority_queue<pr,vector<pr>,greater<pr>> minh;
        for(auto it = mp.begin();it!=mp.end();it++){
            minh.push({it->second,it->first});
            if(minh.size()>k){
                minh.pop();
            }
        }
        vector<int> res;
        while(minh.size() > 0){
            int freq = minh.top().first;
            int ele = minh.top().second;
            for(int i=0;i<freq;i++){
                res.push_back(ele);
            }
            minh.pop();
        }
    }
};