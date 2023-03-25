#include<bits/stdc++.h>
using namespace std;
struct {
    void log(string message){
        cout << "\n" <<  message << endl;
    }
    void print(vector<int> nums){
        for(int i : nums){
            cout << "->"<< i ;
        }
        cout << endl;
    }
} logger;
class KthLargest{
    public:
        KthLargest(){};
        int klarge(vector<int>& nums,int k ){
            // logger.log("Running function klarge");
            return qSelect(nums,nums.size() - k,0,nums.size()-1);
        }
        int qSelect(vector<int>& nums,int k, int start, int end){
            // logger.print(nums);
            if(start == end){
                return nums[k];
            }
            // logger.log("qSelect start ");
            int pos = position(nums,start,end);
            if(pos == k){
                // logger.log("return pos ");
                return nums[pos];
            }
            else if(pos > k){
                // logger.log("pos < k");
                return qSelect(nums,k,start,pos-1);
            }else{
                // logger.log("pos > k");
                return qSelect(nums,k,pos+1,end);
            }
        }
        int position(vector<int>& nums,int start, int pos){
            // logger.log("position ");
            int i =start-1,j=start,temp;
        
            while(j<pos){
                if( nums[j] < nums[pos]){
                    i++;
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
            temp = nums[i+1];
            nums[i+1] = nums[pos];
            nums[pos] = temp;
            return i+1;
        }
};
int main(){
    int k,val;
    logger.log("Enter K");
    cin >> k;
    vector<int> nums;
    logger.log("Enter Value");
    while(true){
        cin >> val;
        if(val == -1) break;
        nums.push_back(val);
        
    }
    KthLargest kth;
    cout << nums.size() << endl;
    int result = kth.klarge(nums,k);
    logger.log("Result");
    cout<< result << endl;
    return 0;
}