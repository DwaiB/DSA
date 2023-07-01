#include<bits/stdc++.h>

using namespace std;
struct {
    void log(string message){
        cout << "\n" <<  message << endl;
    };
    void print(vector<int> nums){
        for(int i : nums){
            cout << "->"<< i ;
        }
    }
    void print(vector<vector<int>> points){
        for (vector<int> point : points){
            cout <<"x,y: "<< point[0] << "," << point[1] << endl;
        }
    }
} logger;
class Solution{
    public:
        vector<vector<int>> kClosest(vector<vector<int>> points, int k){
            vector<vector<int>> result;
            result.insert(result.end(), points[1]);
            return result;
        }
};
int main(){
    vector<vector<int>> points {{1,2},{2,3}};
    int k = 2;
    Solution sol;
    vector<vector<int>> res = sol.kClosest(points, k);
    logger.print(res);
    return 0;
}
