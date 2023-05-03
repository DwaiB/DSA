#include<bits/stdc++.h>
#include<string>
using namespace std;
class Solution {
    public:
        string multiply(string num1, string num2) {
            int i = num1.size() -1;
            string sum,idx0;
            while(i>=0){
                string m_res = digit_multiply(num1[i], num2);
                
                m_res+=idx0;
                idx0+="0";
                sum = digit_sum(m_res,sum);
                i--;
            }
            return sum;
        }
        string digit_multiply(char ch, string num2){
            int num1 = ch -'0';
            int s_num2 = num2.size()-1;
            int sum = 0,carry = 0;
            string ans;

            while(s_num2 >=0){
                sum = num2[s_num2] - '0';
                sum *= num1;
                sum += carry;
                carry = sum/10;
                sum = sum%10;
                ch = sum + '0';
                ans = ch + ans;
                s_num2--;
            }
            if(carry !=0){
                ch = carry + '0';
                ans = ch + ans;
            }
            return ans;
        }
        string digit_sum(string num1,string num2){
            int s_num1 = num1.size()-1,s_num2 = num2.size()-1;
            char res;
            int sum=0,carry=0;
            string ans;
            // int k = sizeof(res);
            while(s_num1 >=0 && s_num2 >=0){
                sum += num1[s_num1] - '0';
                sum += num2[s_num2] - '0';
                sum += carry;
                carry = sum/10;
                sum = sum%10;
                res = sum + '0';
                ans = res+ ans;
                sum = 0;
                s_num1--;
                s_num2--;
            }
            while (s_num1 >=0){
                sum = num1[s_num1] - '0';
                sum += carry;
                carry = sum/10;
                sum = sum%10;
                res = sum + '0';
                ans = res+ ans;
                s_num1--;
            }
            while (s_num2 >=0){
                sum = num2[s_num2] - '0';
                sum += carry;
                carry = sum/10;
                sum = sum%10;
                res = sum + '0';
                ans = res+ ans;
                s_num2--;
            }
            return ans;
        }
};

int main(){
    Solution sol;
    int t;
    cin >> t;
    while (t-- > 0){
        string s1,s2;
        cin >> s1;
        cin >> s2;
        cout << sol.multiply(s1,s2)<<endl;
    }
    
    return 0;
}