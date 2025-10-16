#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, cnt;
vector<int> population = {};
vector<vector<int>> grid;
vector<vector<bool>> visited;
vector<int> dx = {1, 0, -1, 0};
vector<int> dy = {0, 1, 0, -1};

bool inRange(int x, int y){
    return x>=0 && x<n && y>=0 && y<n;
}

bool canGo(int x, int y){
    if(!inRange(x, y))
        return false;
    // 이미 방문했거나 벽이 있으면 갈 수 없음
    if(visited[x][y] || grid[x][y]==0)
        return false;
    return true;
}

void dfs(int x, int y){
    int nx, ny;
    for(int i = 0; i < 4; i ++){
        nx = x + dx[i];
        ny = y + dy[i];
        if(canGo(nx, ny)){
            cnt++; // 마을사람+1
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}

int main() {

    // 총 사람그룹의 개수, 같은 마을에 있는 사람 수를 오름차순으로 출력
    cin >> n;
    grid.assign(n, vector<int>(n,0));
    visited.assign(n, vector<bool>(n,false));

    for(int i = 0; i < n; i++)
        for(int j = 0 ; j < n; j++)
            cin >> grid[i][j];

    for(int i = 0; i < n; i ++){
        for(int j = 0; j < n; j ++){
            if(canGo(i, j)){
                cnt = 1; // 한 마을의 사람 수 셀 변수
                visited[i][j] = true;
                dfs(i, j);
                population.push_back(cnt);
            }
        }
    }

    cout << (int)population.size() << "\n";
    sort(population.begin(), population.end()); // 오름차순 정렬
    for(int num : population){
        cout << num << "\n";
    }


    return 0;
}