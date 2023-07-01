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
        int positionOfPoint(vector<vector<int>>& points, int start,  int pivot){
            int i = start-1, j = start;
            vector<int> temp;
            while(j<pivot){
                if(euclideanDistance(points[j]) < euclideanDistance(points[pivot])){
                    i++;
                    temp = points[j];
                    points[j] = points[i];
                    points[i] = temp; 
                }
                j++;
            }
            temp = points[pivot];
            points[pivot] = points[i+1];
            points[i+1] = temp;
            return i+1;
        }
        void qSelectPoints(vector<vector<int>>& points, int k, int start, int end){
            if(start >= end){ 
                return;
            }
            int position = positionOfPoint(points, start, end);
            if(position == k){
                return;
            }
            else if(position > k){
                qSelectPoints(points,k,start,position-1);
            }
            else{
                qSelectPoints(points,k,position+1,end);
            }

        }
        vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
            qSelectPoints(points,k-1,0,points.size()-1);
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
