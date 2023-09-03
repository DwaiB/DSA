#include<bits/stdc++.h>
int AND(int,int);
int OR(int,int);

using namespace std;

int main(){
    int A[5][5],P[5][5];
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            A[i][j] = 0;
        }
    }
    A[2][1] = 1;
    A[3][1] = 1;
    A[2][3] = 1;
    A[4][3] = 1;
    A[1][4] = 1;
    A[2][4] = 1;
    A[3][4] = 1;

    cout << "Adjacency Matrix " << endl;
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            cout << A[i][j] << " ";
        }
        cout << endl;
    }

    for(int i =1;i<5;i++){
        for(int j = 1;j<5;j++){
            if(A[i][j] == 0) P[i][j] = 0;
            else P[i][j] = 1;
        }
    }

    for(int k = 1; k < 5;k++){
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5;j++){
                P[i][j] = OR(AND(P[i][k],P[k][j]),P[i][j]);
            }
        }
    }

    cout << "Path Matrix " << endl;
    for(int i = 1; i < 5; i++){
        for(int j = 1;j<5;j++){
            cout << P[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

int AND(int a,int b){
    if(a == 1 && b == 1){
        return 1;
    }
    return 0;
}
int OR(int a,int b){
    if(a == 0 && b == 0){
        return 0;
    }
    return 1;
}
