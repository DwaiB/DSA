#include<bits/stdc++.h>

using namespace std;
struct{
    void log(string s){
        cout << "DEBUG: " << "value = " << s << endl;
    }
    void info(string s){
        cout << "INFO: " << "message: " << s << endl;
    }
} logger;
class Solution {
    public:
        string longestCommonString(string str1,string str2){
            string res="";
            logger.info("LCS: "+str1+" "+ str2);
            for(int i = 0;i<str1.size();i++){
                logger.log(res);
                if((i < str2.size()) && (str2[i] == str1[i])){
                    res+=str1[i];
                }
                else{
                    return res;
                }
            }
            return res;           
        }
        string longestCommonPrefix(vector<string>& strs) {
            if(strs.size()==1) return strs[0];
            string result = strs[0];
            logger.log(result);
            for(int i=1;i<strs.size();i++){
                logger.info("LCP: "+strs[i]);
                logger.log(result);
                result = longestCommonString(strs[i],result);
            }
            return result;
        }
};

int main(){
    Solution sol;
    vector<string> strs {"flour","flower","floor"};
    string res = sol.longestCommonPrefix(strs);
    cout << "Res: " << res << endl;
    return 0;
}