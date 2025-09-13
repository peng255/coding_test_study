import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y, int n){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int getDir(char dir){
        if (dir == 'U'){
            return 0;
        } else if(dir=='D'){
            return 3;
        } else if (dir=='L'){
            return 1;
        } else return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt(); // T초가 지난 후 구슬 위치구함
        int R = sc.nextInt(); // 구슬 처음 행. -1해야함
        int C = sc.nextInt(); // 구슬 처음 열. -1해야함
        char D = sc.next().charAt(0); // 구슬 처음 방향. UDRL 중 하나
        
        int[][] arr = new int[N][N];

        // 상하 03 좌우 12
        int[] dx = {-1, 0 , 0, 1}; // 세로. 상..하
        int[] dy = {0, -1, 1, 0}; // 가로. .좌우.

        // 구슬 현재 위치 업데이트용. 마지막에 +1 해서 출력하기
        int x = R-1; 
        int y = C-1;
        int timecnt = 0;
        int dirNum = getDir(D);

        // inRange false 나왔을 때 x,y 업데이트x / 시간+1 / 방향 업데이트
        while( timecnt < T ){
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 범위 넘어가면 방향 바꾸고, 시간 지나고, 이동x인채로 다음 진행
            if ( ! inRange(nx, ny, N) ){
                dirNum = 3-dirNum;
                timecnt ++;
                continue;
            }

            x = nx;
            y = ny;

            timecnt ++;
        }

        System.out.printf("%d %d", x+1, y+1);

    }
}