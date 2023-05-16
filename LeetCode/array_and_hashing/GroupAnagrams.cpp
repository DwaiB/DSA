#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, string> key;
        map<string, vector<string> > mp;
        int n = strs.size();
        for(int i=0;i<n;i++){
            string s = strs[i];
            sort(s.begin(),s.end());
            key[strs[i]] = s;
            vector<string> tmp = mp[s];
            tmp.push_back(strs[i]);
            mp[s] = tmp;
        }
        // vector<vector<int>> (mp.begin(),mp.end());
        vector<vector<string>> res;
        for(auto i = mp.begin(); i != mp.end();i++){
            res.push_back(i->second);
        }
        return res;
    }

};
int main (){
    string s = "dafc";
    sort(s.begin(),s.end());
    cout << s << endl;
    return 0;
}