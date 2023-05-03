//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

struct {
    void print(vector<long long>& arr){
        for(long long i = 0; i<arr.size(); i++){
            cout << arr[i] << " "; 
        }
        cout << endl;
    }
    void log(string msg){
        cout << "LOG: " << msg << endl;
    }
} logger;
// } Driver Code Ends
//User function template for C++

class Solution{
public:
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(vector<long long>& arr, int n, int k){
        int lt = 0,rt=0;
        logger.log("LOOP");
        for(int i=0; i<=n/k; i++){
            lt = i*k;
            rt = lt+k-1;
            cout << lt << " " << rt << endl; 
            logger.log("Looping");
            if(rt >= n) reverse(arr,lt,n-1);
            else reverse(arr,lt,rt);
        }
    }
    void reverse(vector<long long>& arr, int lt, int rt){
        logger.log("SWAP");
        logger.print(arr);
        cout << lt << " " << rt << endl; 
        if(lt >= rt) return;
        int temp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = temp;
        
        reverse(arr,lt+1,rt-1);
    }
};

//{ Driver Code Starts.
int main() {
    int t; 
    cin >> t; 
    while(t--){ 
        int n;
        cin >> n; 
        vector<long long> arr; 
        int k;
        cin >> k; 

        for(long long i = 0; i<n; i++)
        {
            long long x;
            cin >> x; 
            arr.push_back(x); 
        }
        Solution ob;
        ob.reverseInGroups(arr, n, k);
        
        for(long long i = 0; i<n; i++){
            cout << arr[i] << " "; 
        }
        cout << endl;
    }
    return 0;
}


// } Driver Code Ends