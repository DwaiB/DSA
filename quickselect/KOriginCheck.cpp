#include<bits/stdc++.h>
using namespace std;
struct{
    void print(vector<vector<int>> points){
        cout << "Vector" << endl;
        for (vector<int> point : points){
            cout <<"x,y: "<< point[0] << "," << point[1] << endl;
        }
    }
} logger;
class Solution {
    public:
        static int euclideanDistance(vector<int> point){
            return point[0]*point[0] + point[1]*point[1];
        }
        
        vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {

            nth_element(points.begin(),points.begin()+k,points.end(),[this](const vector<int> point1,const vector<int> point2){
                return euclideanDistance(point1) < euclideanDistance(point2);
            });
            return vector<vector<int>>(points.begin(),points.begin()+k);
        }
};
int main(){
    vector<vector<int>> points {{3,3},{5,-1},{-2,4}};
    int k = 2;
    Solution sol;
    vector<vector<int>> res = sol.kClosest(points, k);
    logger.print(res);
    return 0;
}
