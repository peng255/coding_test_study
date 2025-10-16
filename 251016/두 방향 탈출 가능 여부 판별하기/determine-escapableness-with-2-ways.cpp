#include <iostream>
#include <vector>
using namespace std;

int n,m;
vector<vector<int>> grid;
vector<vector<bool>> visited;
vector<int> dx = {1, 0}; // 아래 오른쪽 위쪽 왼쪽
vector<int> dy = {0, 1};
int is_success;

bool inRange(int x, int y){
    return x>=0 && x<n && y>=0 && y<m;
}

void dfs(int x, int y){
    if(x==n-1 && y==m-1){
        is_success = 1;
        return;
    }
    int nx, ny;
    for(int i = 0; i < 2; i ++){
        nx = x+dx[i];
        ny = y+dy[i];
        // inrange, 뱀이 없고, 방문한 적 없는 칸만 dfs
        if(inRange(nx, ny) && grid[nx][ny]==1 && !visited[nx][ny]){
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}

int main() {
    // ios::sync_with_stdio(false);

    cin >> n >> m;
    grid.assign(n, vector<int>(m,0)); // 초기화
    visited.assign(n, vector<bool>(m,false));

    for(int i = 0; i < n; i ++)
        for(int j = 0; j < m; j++)
            cin >> grid[i][j];
    
    is_success = 0;
    dfs(0,0);

    cout << is_success;
    return 0;
}