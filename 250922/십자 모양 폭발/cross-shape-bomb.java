import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    
    public static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        grid = new int[n][n];
        for(int i =0; i <n; i ++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int bombX = sc.nextInt();
        int bombY = sc.nextInt();
        bombX--; bombY--;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1}; // 상하좌우
        int bombNum = grid[bombX][bombY];
        // grid[bombX][bombY] = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                for(int d = 0; d < 4; d++){
                    for(int k = 0; k < bombNum; k ++){
                        int nx = bombX + dx[d]*k;
                        int ny = bombY + dy[d]*k;
                        if(!inRange(nx, ny))
                            break; // 범위 넘어가면 이쪽 방향은 더 진행x
                        grid[nx][ny] = 0;
                    }
                }
            }
        }
        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        
        int[][] temp = new int[n][n];
        for(int j = 0; j<n; j++){
            // 한 세로줄마다 리셋
            int idx = n-1; //temp의 아래서부터 쌓으면서 맨 위의 idx를 기록 
            for(int i = n-1; i >= 0; i--){ // 아래서부터 위로 훑음 
                // 세로/세로/세로.. 이렇게 보도록 i를 안쪽에
                if(grid[i][j] != 0){
                    temp[idx--][j] = grid[i][j];
                }
            }
        }

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

        

    }
}