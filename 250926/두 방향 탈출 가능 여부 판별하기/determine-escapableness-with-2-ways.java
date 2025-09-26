
import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] visited, grid;
	static int result = 0;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		n = Integer.parseInt(st.nextToken()); // int[n][m]
		m = Integer.parseInt(st.nextToken());
		visited = new int[n][m];
		grid = new int[n][m]; // 뱀이 없을 때!! 1, 있으면 0
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = 1; // 시작 칸 visited 표시
		DFS(0,0);
		
		
		bw.write(String.valueOf(result));
		bw.close();
	}
	
	public static void DFS(int x, int y) {
		int[] dx = {1, 0}; //아래 오른쪽 순서로 이동가능
		int[] dy = {0, 1};
		
		for(int i = 0 ; i <2; i ++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(canGo(newX, newY)) {
				if(newX==(n-1) && newY==(m-1)) {
					result = 1;
					return; // 맨 오른쪽 아래에 canGo 상태가 판별되면 탈출가능 확인완료
				}
				visited[newX][newY] = 1;
				DFS(newX, newY);
			}
		}
	}
	
	public static boolean inRange(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	public static boolean canGo(int x, int y) {
		if( !inRange(x, y)) {
			return false;
		}
		// range 안넘어가고, 뱀 없고, 방문 안했으면 갈 수 있음
		if( grid[x][y]==1 && visited[x][y]==0 ) {
			return true;
		}
		return false;
	}
}
