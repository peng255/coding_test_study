import java.util.*;
public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // a행 b열 -> [a-1][b-1] [x][y]
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1}; // 우 하 좌 상

        int cntOne = 0;
        int cntResult=0;
        for (int i=0; i < n; i ++){
            for (int j =0; j < n; j++){
                // 점마다 cntOne 초기화
                cntOne = 0;

                for(int dirNum = 0; dirNum < 4; dirNum++){
                    int nx = i + dx[dirNum];
                    int ny = j + dy[dirNum];
                    if(inRange(nx, ny) && arr[nx][ny]==1){
                        cntOne ++;
                    }
                }
                if (cntOne >= 3){
                    cntResult ++;
                }
            }
        }

        System.out.print(cntResult);
    }
}