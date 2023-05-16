#include<bits/stdc++.h>
using namespace std;

struct{
    void log(string s){
        cout << "INFO:" << s << endl;
    }
} logger;
class Solution{
    public:
        void validate(int x){
            size_t max = INT_MAX;
            cout << max << endl;
            // logger.log("max: "+max);
            size_t maaxx = pow(2,31) ;
            cout << maaxx << endl;
            // logger.log("max: "+maaxx);
        }
};

int main(){
    Solution sol;
    sol.validate(1);
    return 0;
}