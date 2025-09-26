
import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine().trim()); // 1~n까지의 수로 만들 수 있는 모든 순서..
		visited = new boolean[n+1]; // visited[3]==true면 이미 순열에 쓰임 
		
		func(0);
		
		bw.write(sb.toString());
		bw.close();
	}
	
	// written 개의 숫자가 이미 채워짐
	public static void func(int written) {
		if(written == n) {
			// 모든 숫자를 다 썼으면 프린트하고 return
			print();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			// 이미 쓰인 숫자로는 재귀를 돌지 않음
			if( ! visited[i] ) {
				result.add(i);
				visited[i] = true;
				
				func(written + 1); // 다음자릿수 채우러 보냄
				
				// 프린트하고 돌아왔으면 지금 자릿수 없애고 다음 숫자로 넘어가기
				result.remove(result.size()-1);
				visited[i] = false;
			}

		}
		
	}
	
	public static void print() {
		for(int num : result) {
			sb.append(num).append(" ");
		}
		sb.append("\n");
	}
}
