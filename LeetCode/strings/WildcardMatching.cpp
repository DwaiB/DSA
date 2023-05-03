#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        return checkMatch(s,p,0,0);
    }
    bool checkMatch(string s,string p, int s_idx,int p_idx){
        char s_ch,p_ch;
        bool res;
        while(p_idx<p.size()){
            if(s_idx >s.size()-1) break; 
            s_ch = s[s_idx];
            p_ch = p[p_idx];
            if(s_ch == p_ch || p_ch == '?'){
                s_idx++;
            }
            else if ((p_idx+1 < p.size() ) &&  (p_ch == '*') && p[p_idx+1] == s[s_idx]){
                res = checkMatch(s,p,s_idx,p_idx+1);
                if(res){
                    return true;
                }
                else{
                    s_idx++;
                    continue;
                }
            }
            else if ((p_idx+1 < p.size() ) &&  (p_ch == '*') && p[p_idx+1] != s[s_idx]){
                s_idx++;
                continue;
            }
            else if(p_ch == '*'){
                s_idx++;
                continue;
            }
            else{
                return false;
            }
            p_idx++;
        }
        if(s_idx < s.size()) return false;
        else if ( p_idx < p.size() && p[p_idx] != '*'){
            return false;
        }
        else{
            return true;
        }
    }
};