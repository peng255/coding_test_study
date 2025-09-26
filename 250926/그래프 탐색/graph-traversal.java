import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] graph;
	static int n, m;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		n = Integer.parseInt(st.nextToken()); // 점 개수
		m = Integer.parseInt(st.nextToken()); // edge 개수
		
		graph = new ArrayList[n+1];
		for(int i =1; i < n+1; i ++) {
			graph[i] = new ArrayList<Integer>();
		}
		visited = new boolean[n+1]; // 기본 초기화 값 false
		
		// 그래프 세팅
		for(int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[start].add(to);
			graph[to].add(start); // 방향 그래프가 아니라서 양쪽으로 더해줘야함
		}
		
		cnt = 0;
		visited[1] = true; // 출발점은 이미 방문했다고 표시해줘야함!
		DFS(1);
		
		bw.write(String.valueOf(cnt));
		bw.close();
	}
	
	public static void DFS(int vertex) {
		for(int i = 0; i < graph[vertex].size(); i++) {
			int currV = graph[vertex].get(i);
			// 연결된 점 아직 방문 안했으면
			if( !visited[currV] ) {
				// 조합, 순열처럼 다시 false로 표시할 필요x
				visited[currV] = true;
				cnt++;
				DFS(currV);
			}
		}
		
	}
}
