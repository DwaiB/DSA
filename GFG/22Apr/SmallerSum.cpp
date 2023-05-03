//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

struct
{
    void print(vector<long long> &arr)
    {
        for (long long i = 0; i < arr.size(); i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    void print(vector<int> &arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
    void log(string msg)
    {
        cout << "LOG: " << msg << endl;
    }
} logger;
// } Driver Code Ends
// User function Template for C++
class Solution
{
public:
    vector<long long> smallerSum(int n, vector<int> &arr)
    {
        map<int, int> dict;
        vector<long long> res(n);
        vector <int> arrcpy(arr);
        sort(arrcpy.begin(),arrcpy.end());
        int psum = arrcpy[0];
        for (int i =1; i< n;i++)
        {
            if(arrcpy[i] == arrcpy[i-1]){
                dict[arrcpy[i]] = arrcpy[i-1];
            }
            else
                dict[arrcpy[i]] = psum;
            psum+=arr[i];
        }
        for(int i = 0; i< n;i++){
            res[i] = dict[arr[i]];
        }
        return res;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }
        Solution ob;
        vector<long long> ans = ob.smallerSum(n, arr);
        for (int i = 0; i < n; i++)
        {
            if (i != n - 1)
            {
                cout << ans[i] << " ";
            }
            else
            {
                cout << ans[i] << endl;
            }
        }
    }
    return 0;
}
// } Driver Code Ends