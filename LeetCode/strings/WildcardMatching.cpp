#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        return checkMatch(s,p,0,0);
    }
    bool checkMatch(string s,string p, int s_idx,int p_idx){
        if(p_idx == p.size()){
            return s_idx == s.size();
        }
        if( p[p_idx] == '*') return checkMatch(s,p,s_idx,p_idx+1) || (s_idx < s.size() && checkMatch(s,p,s_idx+1,p_idx));
        if( s_idx < s.size() && (s[s_idx] == p[p_idx] || p[p_idx] == '?')){
            return checkMatch(s,p,s_idx+1,p_idx+1);
        }
        return false;
    }
};