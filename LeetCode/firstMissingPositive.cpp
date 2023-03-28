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
        sort(nums.begin(),nums.end(),[this](int a, int b){ return a > b; });
        int result = nums[0]+1;
        for(int i = 1; i <nums.size();i++){
            if(nums[i]<1) break;
            if(nums[i] < result && (nums[i-1]-nums[i] > 1)){
                result = nums[i]+1;
            }
        }
        return result;
    }
};
int main(){
    vector<int> nums{1,2,0};
    Solution sol;
    int res = sol.firstMissingPositive(nums);
    cout << res << endl;
    logger.print(nums);
    return 0;
}