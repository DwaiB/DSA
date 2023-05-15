#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int lo=0,maxlen=0;
    string longestPalindrome(string s) {
        if(s.size() < 2) return s;
        lo=0,maxlen=0;
        for(int i=0;i<s.size()-1;i++){
            extendPalin(s,i,i);
            extendPalin(s,i,i+1);
        }
        cout << "LOW: " << lo << " Max len: " << lo+maxlen << " String: " << s.substr(lo,lo+maxlen-1) << endl;
        return s.substr(lo,lo+maxlen);
    }
    void extendPalin( string s, int i , int j){
        while ( i >=0 && j < s.size()){
            if(s[i] == s[j]){
                i--;
                j++;
            }
            else break;
        }
        i++;
        if(maxlen < j-i){
            
            lo = i;
            maxlen = j-i;
            cout << "i: " << i << " j: " << j << endl;
        }
    }
};


int main(){
    Solution sol;
    string s;
    while (true){
        cin >> s;
        cout << (sol.longestPalindrome(s)) << endl;
    }
    return 0;
}