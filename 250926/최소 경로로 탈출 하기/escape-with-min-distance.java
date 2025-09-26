import java.util.*;
import java.io.*;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int n, m;
	static int[][] grid, distanceMap, visited;
	static Queue<Pair> q = new LinkedList<>(); // 다음으로 탐색할 칸을 저장
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		grid = new int[n][m]; // 뱀이 없으면 1, 있으면 0 저장
		distanceMap = new int[n][m]; // (0,0)으로부터의 거리를 기록
		visited = new int[n][m]; // BFS를 돌면서 한번 방문하면 1로 표시
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 시작점 큐에 넣고, visited 표시하는 단계
		q.add(new Pair(0,0));
		visited[0][0] = 1;
		
		BFS();
		
		System.out.println(distanceMap[n-1][m-1]);
	}
	
	public static void BFS() {
		int[] dx = {-1, 1, 0, 0}; //상하 좌우
		int[] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			
			for(int i = 0; i < 4; i ++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
//				System.out.printf("nx %d ny %d canGo %b\n",nx, ny, canGo(nx, ny));
				// 검사했을 때 nx ny가 갈 수 있는 칸이면
				if(canGo(nx, ny)) {
					visited[nx][ny] = 1; // visited 기록
					// 현재 기준 칸의 거리값 +1을 기록
					distanceMap[nx][ny] = distanceMap[x][y] + 1;
					q.add(new Pair(nx, ny)); // 나중에 큐에서 꺼내서 또 탐색하게 넣음
				}
			}
		}
		
	}
	
	public static boolean inRange(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	public static boolean canGo(int x, int y) {
		if( !inRange(x, y))
			return false;
		// 갈수있는 길(1)이라고 표시돼잇고, 아직 방문 안했으면 갈 수 있음
		if( grid[x][y]==1 && visited[x][y]!=1) {
			return true;
		}
		return false;
	}
}
