#include<bits/stdc++.h>

using namespace std;
struct {
    void log(string message){
        cout << "\n" <<  message << endl;
    };
    void print(vector<int> nums){
        for(int i : nums){
            cout << "->"<< i ;
        }
    }
} logger;
void rev(vector<int>& nums){
    // int size = nums.size();
    // for(int i = 0; i < size;i++){

    // }
    logger.log("Before\n");
    logger.print(nums);
    int temp  = nums[1];
    nums[1] = nums[2];
    nums[2] = temp;
}
void toRev(vector<int>& nums){
    logger.log("Revving");
    rev(nums);
}
int main(){
   vector<int> nums {1,2,3};
   toRev(nums); 
   logger.log("\nAfter");
    logger.print(nums);
}