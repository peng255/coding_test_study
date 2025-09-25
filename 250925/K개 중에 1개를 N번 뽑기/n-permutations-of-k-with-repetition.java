import java.util.*;
import java.io.*;

public class Main {
    
    public static int n, k;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        recursive(1);
        
    }

    public static void recursive(int depth){
        if(depth==k+1){ // k가 3이라면 앞에서 이미 1 2 3번째 자리에 숫자 들어있음
            printResult();
            return;
        }

        for(int i = 1; i<= n; i ++){
            result.add(i);
            recursive(depth+1);
            result.remove(result.size()-1);
        }

        return;
    }

    public static void printResult(){
        for(int num : result){
            System.out.print(num + " ");
        }
        System.out.println();
    }

}