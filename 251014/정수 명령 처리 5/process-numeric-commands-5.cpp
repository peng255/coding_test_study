#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {

    int n;
    string command;
    int num;

    vector<int> v;

    cin >> n;
    for(int i = 0; i <n;  i++){
        cin >> command;
        if(command == "size"){
            cout << v.size() << "\n";
        }
        else if(command == "push_back"){
            cin >> num;
            v.push_back(num);
        } else if(command == "pop_back"){
            v.pop_back();
        } else if(command == "get"){
            cin >> num;
            cout << v[num-1] << "\n";
        }
    }

    return 0;
}