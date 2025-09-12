import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int OFFSET = 100;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt()+ OFFSET;
            y1[i] = sc.nextInt()+ OFFSET;
            x2[i] = sc.nextInt()+ OFFSET;
            y2[i] = sc.nextInt()+ OFFSET;
        }
        // -> x, y 좌표는 0 ~ 200이 된다

        int[][] map = new int[200 + 1][200 + 1];

        for (int i =0 ; i < n; i ++){
            // x1 ~ x2-1까지
            for (int j = x1[i]; j < x2[i]; j++){
                for (int k = y1[i]; k < y2[i]; k++){
                    map[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 201; i ++){
            for (int j =0; j < 201; j ++){
                sum += map[i][j];
            }
        }
        
        System.out.println(sum);


    }
}