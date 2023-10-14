#include<bits/stdc++.h>
int MIN(int,int);

using namespace std;

int main(){
    int A[5][5],P[5][5];
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            A[i][j] = 0;
        }
    }
    A[2][1] = 2;
    A[3][1] = 3;
    A[2][3] = 3;
    A[4][3] = 4;
    A[1][4] = 2;
    A[2][4] = 3;
    A[3][4] = 2;

    cout << "Adjacency Matrix " << endl;
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            cout << A[i][j] << " ";
        }
        cout << endl;
    }

    for(int i =1;i<5;i++){
        for(int j = 1;j<5;j++){
            P[i][j] = A[i][j];
        }
    }

    for(int k = 1; k < 5;k++){
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5;j++){
                P[i][j] = MIN(P[i][k]+P[k][j],P[i][j]);
            }
        }
    }

    cout << "Dijkstra's Matrix " << endl;
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            cout << P[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

int MIN(int a,int b){
    return a < b ? a : b;
}
