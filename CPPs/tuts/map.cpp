#include<bits/stdc++.h>
#include<unistd.h>
using namespace std;
void loading(){

}
int main(){
    map<int,int> dicto;
    dicto[2] = 1;
    dicto[3] = 2;
    dicto[1] = 3;
    dicto[4] = 4;
    for (const auto& n : dicto)
        cout << '[' << n.first << "] = " << n.second << "; ";
    cout << dicto[2]<< endl;
    cout <<"Loading: ";
    for(int i =0;;i++){
        sleep(1);
        cout << "\b-"<<flush;
        sleep(1);
        cout << "\b\\"<<flush;
        sleep(1);
        cout <<"\b|" << flush;
        sleep(1); 
        cout << "\b/"<<flush;
        
    }
    return 0;
}