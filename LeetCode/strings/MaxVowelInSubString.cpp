#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    int maxVowels(string s, int k) {
        // Brute Force
        // 
        // int maxlen = 0,c=0;
        // for(int i =0;i< s.size();i++){
        //     c=0;
        //     for(int j=i;j<i+k;j++){
        //         if(s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u'){
        //             c++;
        //         }
        //     }
        //     if(c>maxlen) maxlen = c;
        // }
        // return maxlen;
        int i =-1,j=0,c=0,maxlen=0;
        vector<int> arr(s.size());
        for(;j<s.size();j++){
            i = ((j-k)>=0)?arr[j-k] : 0;
            if(s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u'){
                c++;
            }
            arr[j] = c;
            maxlen = max(maxlen,arr[j]-i);
        }
        return maxlen;
    }
};


int main(){
    Solution sol;
    int t,k;
    string s;
    cin >> t;
    while(t>0){
        cin >> s;
        cin >> k;
        cout << sol.maxVowels(s,k)<< endl;
    }
    
}