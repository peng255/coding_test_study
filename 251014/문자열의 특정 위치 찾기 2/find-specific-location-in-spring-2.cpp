#include <iostream>
#include <string>
using namespace std;

int main() {
    int cnt = 0;
    string arr[5];
    arr[0] = "apple";
    arr[1] = "banana";
    arr[2] = "grape";
    arr[3] = "blueberry";
    arr[4] = "orange";
    char c;
    cin >> c;

    for(int i = 0; i < 5; i++){
        if( arr[i][2] == c || arr[i][3] == c){
            cout << arr[i] << "\n";
            cnt++;
        }
    }
    cout << cnt;


    return 0;
}