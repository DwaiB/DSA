#include<bits/stdc++.h>
using namespace std;
class Solution {
    private: 
        class sort_indices{
        private:
            vector<int> mparr;
        public:
            sort_indices(vector<int>& parr): mparr(parr){}
            bool operator()(int i,int j) const {return mparr[i] < mparr[j];}
        };
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<float> velocity;
        float cal=0;
        stack<pair<int,float>> stk;
        int n = position.size();
        for(int i=0;i<n;i++){
            cal = float(target-position[i])/speed[i];
            velocity.push_back(cal);
        }
        // sort(velocity.begin(),velocity.begin()+n,sort_indices(position));
        for(int i=0;i<n;i++){
            cout << i << " : "<<velocity[i] << endl;
        }
        return 0;
        // vector<int> res;
        // for(int;i++){
        //     if(stk.empty()){
        //         res.push_back(0);
        //     }
        //     else if (stk.top().second >= i->second){
               
        //     }
        //     else{
        //         while(stk.size() >0 && stk.top().second <i->second){
        //             stk.pop();
        //         }
        //         if(stk.size() ==0)
                    
        //         else
                   
        //     }
        //     stk.push({res.size()-1,i->second});
        // }
        // reverse(res.begin(),res.end());
        // for(int i=0;i<res.size();i++){
        //     cout << res[i] << " " ;
        // }
        // bool g_one = false;
        // int ans =0;
        // for(int i=0;i<n;i++){
           
        // }
        // return ans;
    }
};

int main(){
    int target=12;
    vector<int> position {10,8,0,5,3};
    vector<int> speed {2,4,1,1,3};
    Solution sol;
    cout << sol.carFleet(target,position,speed) << endl;
    return 0;
}