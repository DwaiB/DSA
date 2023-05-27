#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        
        int n = numbers.size();
        int low = 0,high=n-1;
        while(low < high) {
            if(numbers[low]+numbers[high] == target)
                break;
            else if (numbers[low]+numbers[high] < target)
                low+=1;
            else
                high-=1;
        }
        return vector<int> {low,high};
    }
};