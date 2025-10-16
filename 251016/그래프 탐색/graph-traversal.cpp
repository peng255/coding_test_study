#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> visited;
vector<vector<int>> graph;

int dfs(int cur, int cnt){
    // cur 노드에 연결된 노드 리스트 순회
    for(int num : graph[cur]){
        if(visited[num] == 1)
            continue;
        visited[num] = 1; // 방문표시하기
        cnt++;
        cnt = dfs(num, cnt);
    }
    // visited 아닌 점을 모두 돌았으면 return
    return cnt;
}

int main() {

    // 1번 노드에서 시작해서 도달할 수 있는 서로다른 정점의 수
    cin >> n;
    cin >> m;

    visited.assign(n+1,0); // 점i를 방문했으면 visited[i]==1 

    //graph[i]는 점i에 연결된 점들 vector<int>
    graph.assign(n+1, vector<int>()); // 빈 벡터로 각 줄을 초기화 vector<int>()
    
    for(int i = 0; i < m; i++){
        int s, e;
        cin >> s;
        cin >> e;
        graph[s].push_back(e);
        graph[e].push_back(s);
    }

    visited[1] = 1;
    cout << dfs(1, 0);
    return 0;
}

