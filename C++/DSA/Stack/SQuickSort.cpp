#include<bits/stdc++.h>
using namespace std;

struct {
    void print(vector<int> arr){
        for(int i=0;i<arr.size();i++){
            cout <<": "<< arr[i];
        }
        cout<< endl;
    }
} logger;
class Sort{
    public:
        /*
        This function returns the location of the first element in the sorted position LOC
        Smaller elements are on LEFT < LOC < RIGHT has the greater elements than ARR[LOC]
        */
        int Quick(vector<int>& nums,int n, int begin, int end){
            int left = begin,right=end,loc= begin;
            while(true){
                while(loc !=right && nums[loc]<= nums[right]){
                    right--;
                }
                if(loc==right) return loc;
                if(nums[loc]>nums[right]){
                    int tmp = nums[right];
                    nums[right] = nums[loc];
                    nums[loc] = tmp;
                    loc= right;
                }
                while(loc !=left && nums[loc] >= nums[left]){
                    left++;
                }
                if(loc==left) return loc;
                if(nums[loc]< nums[left]){
                    int tmp = nums[left];
                    nums[left] = nums[loc];
                    nums[loc] = tmp;
                    loc= left;
                }
            }
        }
        /*
        This function sorts the Array based on lower and upper bounds
        It finds the correct position of eleemnt in array : LOC 
        The two sub arrays LEFT and RIGHT to it are then send to Quick function
        and the Sorting is done by dividing the array till all elements are in correct pos
        */
        void QuicSort(vector<int>& nums, int n){
            stack<int> lower,upper;
            int top=-1,loc,begin,end;
            int c=0;
            if(n>1){
                top=0;
                lower.push(0);
                upper.push(n-1);
            }
            while(top!=-1){
                
                begin = lower.top();
                end  = upper.top();
                lower.pop();
                upper.pop();
                top--;
                loc = Quick(nums,n,begin,end);
                if(begin<loc-1){
                    top++;
                    lower.push(begin);
                    upper.push(loc-1);
                }
                if(end>loc+1){
                    top++;
                    lower.push(loc+1);
                    upper.push(end);
                }
            }
        }
};
int main(){
    vector<int> arr {44,33,11,55,77,90,40,60,99,22,88,66};
    Sort q;
    int n = arr.size();
    q.QuicSort(arr,n);
    logger.print(arr);
    return 0;
}
