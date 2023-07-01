#include<bits/stdc++.h>
#include "Stack/stack.h"
using namespace std;
int main(){
    Stack s;
    s.push(10);
    s.push(12);
    s.pop();
    cout << "Top "<< s.top() <<endl;
    s.push(13);
    s.print();
    return 0;
}
