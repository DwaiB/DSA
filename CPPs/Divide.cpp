#include<bits/stdc++.h>
using namespace std;
struct{
    void print(string s){
        cout <<  s << endl;
    }
    void log(string s){
        cout << "INFO: " << s << endl;
    }
} logger;
class Solution {
public:
    int divide(int dividend, int divisor) {
        return dividend & divisor;   
    }
};
int main(){
    Solution sol;
    int divd,divr;
    while(true){
        logger.print("Enter Dividend");
        cin >> divd;
        logger.print("Enter Divisor");
        cin >> divr;
        int res = sol.divide(divd,divr);
        logger.log(" Result:"+res);
        logger.print("continue (Y/n)");
        char ch;
        cin >> ch;
        if(ch == 'n') break;
    }
    return 0;
}