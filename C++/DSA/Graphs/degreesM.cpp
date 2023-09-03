#include<bits/stdc++.h>

using namespace std;
#define Max 15

void buildAdjMatrix(int adj[][Max],int n){
    for(int i =0; i< n;i++){
        for(int j = 0; j < n;j++){
            cout << "e ("<< i+1 << ", "<< j+1 << "): ";
            cin >> adj[i][j];
        }
    }
}
void printMatrix(int adj[][Max], int n){
    cout << "Graph " << endl;
    for(int i =0; i< n;i++){
        for(int j = 0; j < n;j++){
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }
}
int inDegree(int adj[][Max], int x, int n){
    int count =0;
    for(int i =0; i< n;i++){
       if(adj[x][i] !=0) count++;
    }
    return count;
}
int outDegree(int adj[][Max], int x, int n){
    int count =0;
    for(int i =0; i< n;i++){
       if(adj[i][x] !=0) count++;
    }
    return count;
}

int main(){
    int mat[Max][Max], n,i;
    cout << " Enter the nodes in Graph (Max 15)"<< endl;
    cin >> n;
    buildAdjMatrix(mat,n);
    printMatrix(mat,n);
    for( int i =0;i<n; i++){
        cout << "The InDegree of Node: "<<(i+1)<<" is "<< inDegree(mat,i,n)<< endl;
        cout << "The OutDegree of Node: "<<(i+1)<<" is "<< outDegree(mat,i,n)<< endl;
    }
    return 0;
}