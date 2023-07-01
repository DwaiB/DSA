#include<bits/stdc++.h>
using namespace std;
typedef pair<int, pair<int,int>> pi;
class Solution {
    public:
        inline auto eDist(vector<int> point){
            return point[0]*point[0] + point[1]*point[1];
        }
        
        vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
            priority_queue<pi> maxh;
            vector<vector<int>> res;
            int n = points.size();
            for(int i=0;i<n;i++){
                maxh.push({eDist(points[i]),{points[i][0],points[i][1]}});
                if(maxh.size() >k){
                    maxh.pop();
                }
            }
            while(maxh.size() >0){
                vector<int> point  {maxh.top().second.first,maxh.top().second.second};
                res.push_back(point);
                maxh.pop();
            }
            
            priority_queue<int,vector<int>,greater<int>> minh;
            return res;
        }
};