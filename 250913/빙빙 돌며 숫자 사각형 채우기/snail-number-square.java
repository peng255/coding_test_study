import java.util.Scanner;
public class Main {
    public static int n, m;

    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<m);
    }

    // 시계방향으로 바꾸려면 0 1 2 3 0 1 2.. (dirNum + 1)%4
    public static int turnClockwise(int dirNum){
        return (dirNum + 1)%4;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] result = new int[n][m];

        // 오른쪽 아래쪽 왼쪽 위쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        int num = 1;
        int dirNum = 0;

        while(num <= n * m){
            // 현재 칸에 기록
            result[x][y] = num;

            // 이동하려는 칸이 inRange이고 result[][] == 0이면 x y 업데이트
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];
            if( inRange(nx, ny) && result[nx][ny]==0 ){
                x = nx;
                y = ny;
            }

            // else 방향을 바꾸고 x y 업데이트
            else {
                dirNum = turnClockwise(dirNum);
                x = x + dx[dirNum];
                y = y + dy[dirNum];
            }

            num++;
        }

        for (int i= 0; i < n; i ++){
            for (int j =0; j < m; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}