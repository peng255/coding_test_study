import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }

        // 전체 범위에서 최댓값 인덱스 구하기
        int end = find(n);
        System.out.print(end+1 + " ");

        while(true){
            
            // 이전 max 인덱스는 포함하지 않는 범위에서 최대인덱스 찾기
            end = find(end-1);
            System.out.print(end+1 + " ");

            if(end==0){
                break;
            }
        }
        
    }

    // 0~end 범위 안에서 max 인덱스 찾음
    public static int find(int end){
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        
        for (int i = 0; i < end ; i ++){
            if(arr[i] > max){
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;

    }
}