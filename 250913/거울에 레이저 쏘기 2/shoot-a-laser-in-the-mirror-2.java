import java.util.*;

public class Main {

    public static int n, k;
    public static char[][] map;

    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int reflect(int dirNum, char slash){
        // "/" 만나면 오른쪽0<->위쪽3 / 왼쪽1<->아래쪽2
        // int[] dxSlash = {0, 0, 1, -1}; // 오 왼 아 위
        // int[] dySlash = {1, -1, 0 , 0};
        // // "\" 만나면 오른쪽<->아래쪽 / 왼쪽<->위쪽

        if( slash == '/'){
            return 3-dirNum;
        } else {
            // 0<->2  1<->3
            return (dirNum + 2) % 4;
        }
        
    }    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new char[n][n];
        int x, y;
        int cnt=0;
        int dirNum;
        int[] dxSlash = {0, 0, 1, -1}; // 오 왼 아 위
        int[] dySlash = {1, -1, 0 , 0};

        for (int i = 0; i < n; i ++){
            String line = sc.next();
            for (int j = 0; j < n; j ++){
                map[i][j] = line.charAt(j);
            }
        }

        k = sc.nextInt(); // 1~4N 중에 시작 방향, 위치
        // 1~n, n+1 ~ 2n, 2n+1 ~ 3n, 3n+1 ~ 4n
        if( k<=n ){ // 아래쪽방향, 시작지점 [0][k-1]
            dirNum = 2;
            x = 0;
            y = k-1;
        } else if ( k<= 2*n ){ // 왼쪽방향, 시작지점 [k-n-1][n-1]
            dirNum = 1;
            x = k-n-1;
            y = n-1;
        } else if ( k<= 3*n ){ // 위쪽방향, 시작지점 [n-1][3*n-k]
            dirNum = 3;
            x = n-1;
            y = 3*n - k;
        } else { // 오른쪽방향, 시작지점 [4n-k][0]
            dirNum = 0;
            x = 4*n - k;
            y = 0;
        }

         // range를 벗어나면 튕기는 횟수 그만 셈
        while(inRange(x, y)){
            cnt ++; // 튕긴횟수 +1

            // 반사 후 진행방향 구하고 이동
            dirNum = reflect(dirNum, map[x][y]);
            x = x + dxSlash[dirNum];
            y = y + dySlash[dirNum];

        }
       
        System.out.println(cnt);

    }
}