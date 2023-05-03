#include<bits/stdc++.h>

using namespace std;

class Solution {
    public:
        vector<vector<int>> ans;
        vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            ans.clear();
            vector<int> temp;
            combo(0,candidates,temp,target);
            return ans;
        }

        void combo(int idx, vector<int>& candidates, vector<int>& temp, int target) {
            if(target == 0){
                ans.push_back(temp);
                return;
            }
            if(target < 0)
                return;
            if(idx == candidates.size())
                return;
            combo(idx+1, candidates, temp, target);
            temp.push_back(candidates[idx]);
            combo(idx, candidates, temp, target-candidates[idx]);
            temp.pop_back();
        }
};

int main(){

    return 0;
}