import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];

        int r, c;
        int cnt = 1;
        for (int i = 0; i < m; i ++){
            r = sc.nextInt();
            c = sc.nextInt();

            arr[r-1][c-1] = cnt;
            cnt++;     
        }

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    
    }
}