#include<bits/stdc++.h>
#include<unistd.h>
using namespace std;
void loading(){

}
int main(){
    map<int,int> dicto;
    dicto[2] = 1;
    for (const auto& n : dicto)
        cout << '[' << n.first << "] = " << n.second << "; ";
    dicto.erase(dicto.find(2));
    cout <<endl;
    for (const auto& n : dicto)
        cout << '[' << n.first << "] = " << n.second << "; ";
    cout <<endl;
    cout << dicto.size()<< endl;
    // cout <<"Loading: ";
    // for(int i =0;;i++){
    //     sleep(1);
    //     cout << "\b-"<<flush;
    //     sleep(1);
    //     cout << "\b\\"<<flush;
    //     sleep(1);
    //     cout <<"\b|" << flush;
    //     sleep(1); 
    //     cout << "\b/"<<flush;
        
    // }
    return 0;
}