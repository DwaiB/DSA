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
    double euclideanDistance(vector<int> point){
        double distance = sqrt(point[0]*point[0] + point[1]*point[1]);
        return distance;
    }
    bool nearestToOrigin(vector<int> point1, vector<int> point2) {
        if(euclideanDistance(point1) < euclideanDistance(point2)){
            return true;
        }
        return false;
    }
    int positionOfPoint(vector<vector<int>>& points, int start,  int pivot){
        int i = start-1, j = start;
        vector<int> temp;
        while(j<pivot){
            if(nearestToOrigin(points[j],points[pivot])){
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
    void qSelectPoints(vector<vector<int>>& points, vector<vector<int>>& result, int k, int start, int end){
        if(start >= end){ 
            if(start < k){
                result[start] = points[start];
            }
            return;
        }
        int position = positionOfPoint(points, start, end);
        if(position == k-1){
            result[position] = points[position];
        }
        else if(position >= k){
            qSelectPoints(points,result,k,start,position-1);
        }
        else{
            result[position] = points[position];
            qSelectPoints(points,result,k,position+1,end);
        }

    }
    void DNC(vector<vector<int>>& points, vector<vector<int>>& result, int k,int left,int right){
        if(k==0){
            return;
        }
        qSelectPoints(points,result,k,left,right);
        DNC(points,result,k-1,left,right);
    }
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<vector<int>> result(k);
        DNC(points,result,k,0,points.size()-1);
        return result;
    }
};
int main(){
    vector<vector<int>> points {{0,1},{1,0}};
    int k = 2;
    Solution sol;
    vector<vector<int>> res = sol.kClosest(points, k);
    logger.print(res);
    return 0;
}
