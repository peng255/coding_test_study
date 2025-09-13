import java.util.*;

public class Main {
    public static int n;
    public static int[][] result;
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static boolean checkTurn(int x, int y){
        // 블럭 주변 8칸 중에 이미 칠해진 개수 >= 3개면 방향 그대로 진행
        // <=2개면 시계 반대방향으로 전환
        int[] dxSurr = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dySurr = {1, -1, 0, 1, -1, 0, 1, -1};
        int nx, ny;
        int cntVisited = 0;
        for(int i =0; i < 8; i ++){
            nx = x + dxSurr[i];
            ny = y + dySurr[i];
            if(inRange(nx, ny) && result[nx][ny]!=0){
                cntVisited ++;
                if(cntVisited >=3) {
                    return false;
                }
            }
        }
        // 다 돌아도 주변에 칠해진 칸이 3개를 안넘으면 turn 해야됨
        return true; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 홀수 nxn 배열에서 가운데 칸 : [(n-1)/2] [(n-1)/2]
        int x = (n-1)/2;
        int y = (n-1)/2;
        int dirNum = 0;
        
        int[] dx = {0, -1, 0, 1}; // 오 위 왼 아
        int[] dy = {1, 0, -1, 0};

        result = new int[n][n];

        int cnt = 1;
        while(cnt <= n*n){
            result[x][y] = cnt;

            x += dx[dirNum];
            y += dy[dirNum];

            if(checkTurn(x, y)){
                dirNum = (dirNum + 1) % 4;
            }
            cnt ++;

        }

        for(int i =0 ; i < n; i ++){
            for (int j =0; j <n; j ++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}