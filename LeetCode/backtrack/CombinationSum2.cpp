#include<bits/stdc++.h>

using namespace std;
struct
{
    void print(vector<long long> &arr)
    {
        for (long long i = 0; i < arr.size(); i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    void print(vector<int> arr)
    {
        cout << "\nArray" <<endl;
        for (int i = 0; i < arr.size(); i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    void log(string msg)
    {
        cout << "LOG: " << msg << endl;
    }
} logger;
class Solution {
public:
   vector<vector<int>> ans;
        vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
            ans.clear();
            vector<int> temp;
            sort(candidates.begin(),candidates.end());
            combo(0,candidates,temp,target,candidates.size());
            return ans;
        }

        void combo(int idx, vector<int>& candidates, vector<int>& temp, int target,int n) {
            // logger.print(temp);
            if(target == 0){
                ans.push_back(temp);
                return;
            }
            else if(target < 0)
                return;
            else{
                for(int i = idx;i<n; i++){
                    if(i!=idx && candidates[i] == candidates[i-1]){
                        continue;
                    }
                    temp.push_back(candidates[i]);
                    combo(i+1, candidates, temp, target-candidates[i],n);
                    temp.pop_back();
                }
                
            } 
            
        }
};

int main(){
    
int n,t;
        cin >> n;
        cin >> t;
        vector<int> arr(n);
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        Solution ob;
        vector<vector<int>> ans = ob.combinationSum2(arr,t);
        for (int i = 0; i < ans.size(); i++)
        {
            for (int j = 0; j < ans[i].size(); j++)
            {   
                cout << ans[i][j]<<" ";
            }
            cout  << endl;
        }
    return 0;
}