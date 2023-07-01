#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int k = tasks.size();
        unordered_map<char,int> mpt;
        for(int i=0;i<k;i++){
            mpt[tasks[i]]++;
        }
        int count =0;
        vector<int> lst;
        for(auto it = mpt.begin();it!=mpt.end();it++){
            lst.push_back(it->second);
            if(count<it->second){
                count = it->second;
            }
        }
        int scenario1 = k;
        int mi=0;
        for(int i=0;i<lst.size();i++){
            if(lst[i]==count){
                mi++;
            }
        }
        int scenario2 = (count-1)*(n+1)+mi;
        return max(scenario1,scenario2);
    }
};