import java.util.*;
import java.io.*;

public class Main {
	
	static int startNum;
	static int[] dist, visited;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		startNum = Integer.parseInt(br.readLine().trim());
		dist = new int[startNum + 2]; // 0 1 .. n n+1까지 인덱스 있게 만듦
		visited = new int[startNum + 2];
		
        visited[startNum] = 1; // 시작점 visited 항상 빼먹지 말기 !!!
		q.add(startNum);
		
		BFS();
		System.out.println(dist[1]);
	}
	
	public static void BFS() {
		
		int[] plus = {1, -1, 0, 0};
		int[] div = {1, 1, 2, 3};
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int i = 0; i < 4; i ++) {
				// i=2인데 curr가 2로 안나눠떨어지면 건너뜀
				if( (i==2 && curr%2!=0) || (i==3 && curr%3!=0))
					continue;
				
				// i==3이면 curr/3에 0을 더함
				int newNum = curr / div[i] + plus[i];
				
				// 범위를 넘어가거나 이미 한번 계산으로 나왔던 숫자면 건너뛰기
				if( newNum < 0 || newNum >= startNum+2 || visited[newNum] == 1 )
					continue;
				
				// 범위 안넘어가고 처음 나오는 숫자면 dist 기록하고, visited 표시하고, q에 넣음
				dist[newNum] = dist[curr] + 1;
				visited[newNum] = 1;

                // 만약 새로 계산한 다음 숫자가 1이면 더 볼 필요x return
                if(newNum == 1){
                    return;
                }
				
				q.add(newNum);
			}
		}
	}
}
