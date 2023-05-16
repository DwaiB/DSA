#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        vector<int> stk;
        int n = tokens.size();
        for(int i=0;i<n;i++){
            string s = tokens[i];
            if(s=="+" || s=="-" || s=="*" || s=="/"){
                int num2 = stk.back();
                stk.pop_back();
                int num1 = stk.back();
                stk.pop_back();
                char ch = s[0];
                switch(ch){
                    case '+': stk.push_back(num1+num2); break;
                    case '-': stk.push_back(num1-num2); break;
                    case '*': stk.push_back(num1*num2); break;
                    case '/': stk.push_back(num1/num2); break;
                }
            }
            else{
                stk.push_back(stoi(s));
            }
        }
        return stk.back();
    }
};