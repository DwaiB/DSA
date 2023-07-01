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
        int search(vector<int>& nums,int target, int left,int right){
            if(left==right){
                return (nums[left]< target)?left+1:left;
            }
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] > target){
                return search(nums,target,left,mid-1);
            }
            else{
                return search(nums,target,mid+1,right);
            }
        }
        int searchInsert(vector<int>& nums, int target){
            return search(nums,target,0,nums.size()-1);
        }
};
int main(){
    vector<int> nums{1,2,3,4,5};
    Solution sol;
    int res = sol.searchInsert(nums,3);
    cout << res << endl;
    logger.print(nums);
    return 0;
}