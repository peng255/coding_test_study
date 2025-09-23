import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid, temp, copy;
    public static int centerX, centerY, size;
    
    public static boolean inBombRange(int x, int y){
        // if( x<0 || x>=n || y<0 || y>=n )
        //     return false;
        
        int xDiff = Math.abs(centerX - x);
        int yDiff = Math.abs(centerY - y);
        // System.out.printf("x %d y %d xDiff %d yDiff %d\n", x, y, xDiff, yDiff);
        if( (xDiff==0 && yDiff<size) || (xDiff<size && yDiff==0))
            return true;
        return false;
    }

    public static void copyGrid(){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                copy[i][j] = grid[i][j];
            }
        }
    }

    // 아래로 쭉 내리고 grid에 복사
    public static void push(){

        int nextIdx;
        for(int j = 0; j <= n-1; j++){
            nextIdx = n-1; // 초기화
            for(int i = n-1; i >= 0; i--){
                if(copy[i][j] != 0)
                    temp[nextIdx--][j] = copy[i][j];
            }
        }

        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j++){
        //         copy[i][j] = temp[i][j];
        //     }
        // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        temp = new int[n][n];
        copy = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int maxcnt = 0;
        for(int k = 0; k < n; k++){
            for(int l =0; l < n; l++){
                copyGrid(); // copy <- grid 복사해서 초기화
                temp = new int[n][n]; // temp도 다시 0으로 초기화
                centerX = k; centerY = l; // 폭탄 위치 설정
                size = grid[k][l];

                // 전체 copy 칸 보면서.. 폭탄범위 true이면 0으로
                for(int i = 0; i < n; i ++){
                    for(int j = 0; j < n; j++){
                        if(inBombRange(i, j))
                            copy[i][j] = 0;
                    }
                }

                // for(int i = 0; i < n; i++){
                //     for(int j = 0; j < n; j++){
                //         System.out.print(copy[i][j] + " ");
                //     }
                //     System.out.println();
                // }

                push(); //temp에 폭탄 터진 후 내려간 모양 저장됨

                // for(int i = 0; i < n; i++){
                //     for(int j = 0; j < n; j++){
                //         System.out.print(temp[i][j] + " ");
                //     }
                //     System.out.println();
                // }

                int cnt = 0;
                // 가로에서 같은 2개 개수 찾기
                for(int i = 0; i <= n-1; i++){
                    // 맨 오른쪽 세로줄은 보지 x
                    for(int j= 0; j <= n-2; j++){
                        if(temp[i][j]!=0 && temp[i][j]==temp[i][j+1])
                            cnt++;
                    }
                }
                // 세로방향
                for(int j = 0; j<=n-1; j++){
                    // i+1했을때 n-1 나오게.. n-2까지만 봄
                    for(int i = 0; i<=n-2; i++){
                        if(temp[i][j]!=0 && temp[i][j]==temp[i+1][j])
                            cnt++;
                    }
                }
                
                maxcnt = Math.max(maxcnt, cnt);
            }
        }
        

        System.out.print(maxcnt);

    }
}