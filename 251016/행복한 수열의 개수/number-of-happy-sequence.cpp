#include <iostream>
#include <vector>
using namespace std;

int cnt, n, m;

int main() {
    ios::sync_with_stdio(false);

    cin >> n; // 격자 크기
    cin >> m; // m개 이상의 동일한 원소가 나와야 함

    vector<vector<int>> arr(n, vector<int>(n)); // n*n 배열 0으로 초기화

    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++)
            cin >> arr[i][j];
    }

    // 가로방향 훑기
    int same = 1; 
    for(int i = 0 ; i < n; i ++){
        for(int j = 1; j < n; j++){
            if( arr[i][j-1] != arr[i][j]){
                same = 1; // 왼쪽칸이랑 값 다르면 초기화
            } else {
                same++;
            }
        }
        if(same >= m)
            cnt++;
    }

    for(int j = 0 ; j < n; j++){
        for(int i = 1; i < n; i++){
            if( arr[i-1][j] != arr[i][j]){
                same = 1; // 위쪽칸이랑 값 다르면 초기화
            } else {
                same++;
            }
        }
        if(same >= m)
            cnt++;
    }

    cout << cnt;
    return 0;
}