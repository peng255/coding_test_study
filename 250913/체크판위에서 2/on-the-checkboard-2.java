import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // 찾는 범위 설정
        // 현재위치 [x][y]일때
        // [x+1][y+1] ~ [R-2][C-2]

        int cnt = 0;
        // 첫번째 점프범위 [1][1] ~ [R-3][C-3]
        // 두번째 점프범위 [i+1][j+1] ~ [R-2][C-2]
        for( int i = 1; i <= (R-3); i ++){
            for (int j = 1; j <= (C-3); j ++){
                for (int k = i+1; k <=(R-2); k++){
                    for(int m = j+1; m <=(C-2); m++){
                        // 두 점프지점의 
                        if(grid[i][j] != grid[k][m]){
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.print(cnt);

    }
}