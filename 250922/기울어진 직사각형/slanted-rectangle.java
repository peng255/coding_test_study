import java.util.Scanner;
public class Main {

    public static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static final int DIR_NUM = 4;
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] grid = new int [MAX_N][MAX_N];

    public static int getScore(int x, int y, int k, int l){
        int[] dx = new int[]{-1, -1, 1, 1}; //오른쪽 위, 왼쪽 위, 왼쪽 아래, 오른쪽 아래
        int[] dy = new int[]{1, -1, -1, 1};
        // 1,3방향으로 k번 2,4방향으로 l번 이동
        int[] moveNum = new int[]{k, l, k, l};

        int sumOfNums = 0; // 직사각형 숫자 더한 결과

        //예) dirNum 0일때 k번 for문반복
        for(int d =0; d < DIR_NUM; d++){
            for(int q = 0; q < moveNum[d]; q++){
                x += dx[d]; 
                y += dy[d];

                if(!inRange(x,y))
                return 0; // 경계 벗어나면 점수 0

                // 한칸 움직일때마다 더하기
                sumOfNums += grid[x][y];
            } // 끝까지 쭉 가봄
        }
        return sumOfNums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                for(int k = 1; k < n; k++)
                    for(int l = 1; l<n; l++)
                        ans = Math.max(ans, getScore(i, j, k, l));
        
        System.out.print(ans);
        
    }
}