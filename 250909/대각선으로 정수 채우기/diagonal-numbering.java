import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        int num = 1;

        // 3x4 배열일 때 오른쪽 아래 꼭짓점 (2,3) -> 좌표 합쳤을 때 0~5까지 보면 됨
        for (int k = 0; k <= (n-1)+(m-1); k ++){
            for (int i = 0; i < n; i ++){
                int j = k-i;
                
                // colnum이 네모 범위를 넘어가면 그만두고 다음 k으로 넘어가기
                if( j<0 || j>=m){
                    // System.out.printf("k: %d, i: %d, j: %d\n", k, i, j);
                    continue;
                }

                arr[i][j] = num;
                num++;
            }
        }

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    
    }
}