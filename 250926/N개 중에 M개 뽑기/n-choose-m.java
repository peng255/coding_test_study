import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		n = Integer.parseInt(st.nextToken()); // 1~n 숫자
		m = Integer.parseInt(st.nextToken()); // m개를 골라서 만들 수 있는 조합 구하기. 순열 아님!
				
		
		func(0, 0);
		
		bw.write(sb.toString());
		bw.close();
	}
	
	// depth=3이면 3자리 채워진 상태, prevNum은 직전 자리보다 더 큰 숫자를 넣기 위한 정보
	public static void func(int depth, int prevNum) {
		// 앞으로 채워야하는 자릿수 > n까지 남은 숫자개수면 남은 자리를 채울 수 없으니 조기 return
		if(m-depth > n-prevNum) {
			return; // 프린트 안함
		}
		// 위 조건에 걸리지 않고 여기까지 왔으면 m자리 잘 채웠음 
		if(depth >= m) {
			print();
			return;
		}
		
		for(int i = prevNum + 1; i <= n; i ++) {
			result.add(i);
			func(depth+1, i);
			result.remove(result.size()-1);
		}
		return;
	}
	
	public static void print() {
		for(int num : result) {
			sb.append(num + " ");
		}
		sb.append("\n");
	}
}
