#include<bits/stdc++.h>
using namespace std;

struct {
    void print(vector<int>& nums){
        for(int i : nums){
            cout << i<<",";
        }
        cout <<"\n";
    }
} logger;


class Solution {
    
public:
   int firstMissingPositive(vector<int>& nums) {
       std::ios::sync_with_stdio(0);
        std::cin.tie(0);
        std::cout.tie(0);
        const int n = nums.size();
        
        vector<bool> indexed(n,false);
        for(int i =0;i<n;i++){
            if(nums[i]> 0 && nums[i] <= n){
                indexed[nums[i]-1] = true;
            }
        }
        int ans = n+1;
        for(int i=0;i<n;i++){
            if(!indexed[i]){
                ans =  i+1;
                break;
            }
        }
        return ans;
    }
};
int main(){
    vector<int> nums{1,2,3,4,5};
    Solution sol;
    int res = sol.firstMissingPositive(nums);
    cout << res << endl;
    logger.print(nums);
    return 0;
}