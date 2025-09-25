import java.util.*;
import java.io.*;

public class Main {
	
	public static int k, n;
	public static ArrayList<Integer> result = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		// System.setIn(new FileInputStream("src/coding_test/sample_input.txt"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		k = Integer.parseInt(st.nextToken()); // 1~k 숫자를 고름
		n = Integer.parseInt(st.nextToken()); // n개의 숫자를 고름
		
		recursive(1);
		
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
	public static void recursive(int depth) {
		
		if(depth >= n+1) { // n=3이면 depth 1 2 3까지 숫자 추가하고 4면 프린트하고 return
			print();
			return;
		}
		
		for(int i = 1; i <= k; i ++) {
			// 세번째 이상의 숫자인데 직전 2개의 값이 i랑 같으면 continue
			if(depth>=3 && result.get(depth-2)==i && result.get(depth-3)==i) {
				continue;
			}
			// 첫번째 두번째 숫자이거나.. 세번째 이상의 숫자지만 직전 2개의 값이 다를 때만 새 숫자를 추가함
			result.add(i);
			recursive(depth+1);
			result.remove(result.size()-1);
		}
		return;
	}
	
	public static void print() {
		for(int num : result) {
			sb.append(num).append(' ');
		}
		sb.append("\n");
	}
	
}
