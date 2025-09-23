import java.util.*;

public class Main {
    public static int[][] grid;
    public static int[][] temp = new int[4][4];
    public static int n = 4;

    // 미는 방향을 받아서 grid를 변경. 
    // ex. 2 2면 바닥에 가까운 쪽에 4, 다른쪽은 0으로 설정
    public static void merge(char dir){
        // 아래방향 중력이라면 아래에서 위로 올라가면서 훑음
        if(dir == 'D'){
            for(int j = 0; j <= n-1; j ++){
                for(int i = n-1; i>=1; i--){
                    if(grid[i][j]!=0 && (grid[i][j]==grid[i-1][j])){
                        grid[i][j] *= 2;
                        grid[i-1][j] = 0;
                    }
                }
            }
        } 
        // 아래에서 위로 훑음
        else if(dir == 'U'){
            for(int j = 0; j <= n-1; j++){
                for(int i =0 ; i <= n-2; i++){
                    if(grid[i][j]!=0 && (grid[i][j]==grid[i+1][j])){
                        grid[i][j] *= 2;
                        grid[i+1][j] = 0;
                    }
                }
            }
        }

        // 오른쪽에서 왼쪽으로 훑음
        else if(dir == 'R'){
            for(int i = 0; i <= n-1; i++){
                // j>=0하면 out of bound exception.. 제일 끝줄은 포함x
                for(int j = n-1; j >=1; j--){
                    if(grid[i][j]!=0 && (grid[i][j]==grid[i][j-1])){
                        grid[i][j] *= 2;
                        grid[i][j-1] = 0;
                    }
                }
            }
        }
        // 왼쪽에서 오른쪽으로 훑음
        else if(dir == 'L'){
            for(int i = 0; i <= n-1; i++){
                for(int j = 0; j <= n-2; j++){
                    if(grid[i][j]!=0 && (grid[i][j]==grid[i][j+1])){
                        grid[i][j] *= 2;
                        grid[i][j+1] = 0;
                    }
                }
            }
        }
    }
    
    public static void push(char dir){
        int nextIndex; 
        // 아래방향 중력이라면 아래에서 위로 올라가면서 훑음
        if(dir == 'D'){
            for(int j = 0; j <= n-1; j ++){
                nextIndex = n-1; // 다음 0이 아닌 값을 넣을 인덱스 아래서부터 위로..
                for(int i = n-1; i>=0; i--){
                    if(grid[i][j]!=0){
                        temp[nextIndex--][j] = grid[i][j];
                        // nextindex 감소시키는거 주의
                    }
                }
            }
        } 
        // 아래에서 위로 훑음
        else if(dir == 'U'){
            for(int j = 0; j <= n-1; j++){
                nextIndex = 0; 
                for(int i =0 ; i <= n-1; i++){
                    if(grid[i][j]!=0){
                        temp[nextIndex++][j] = grid[i][j];
                        // 여기서는 숫자 채울수록 아래로 내려가니까 index ++
                    }
                }
            }
        }

        // 오른쪽에서 왼쪽으로 훑음
        else if(dir == 'R'){
            for(int i = 0; i <= n-1; i++){
                nextIndex = n-1; // colnum n-1~0
                for(int j = n-1; j >=0; j--){
                    if(grid[i][j]!=0){
                        temp[i][nextIndex--] = grid[i][j];
                    }
                }
            }
        }
        // 왼쪽에서 오른쪽으로 훑음
        else if(dir == 'L'){
            for(int i = 0; i <= n-1; i++){
                nextIndex = 0;
                for(int j = 0; j <= n-1; j++){
                    if(grid[i][j]!=0){
                        temp[i][nextIndex++] = grid[i][j];
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);

        // 4044 인데 왼쪽으로 밀면 8400되게 하기 위해서..
        // 먼저 4440을 만들고 합치자
        push(dir);

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                grid[i][j] = temp[i][j];

                // 썼던 temp 칸은 다시 0으로 초기화해줘야 다음 push에서 제대로 나옴!!
                temp[i][j] = 0; 
                // System.out.print(grid[i][j] + " ");
            }
            // System.out.println();
        }

        // dir 방향으로 같은 숫자 2개씩 합침. 0 남음
        merge(dir);

        // 0이 아닌 숫자들을 dir 방향으로 쏠리게 해서 temp에 저장
        push(dir);
        
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

    }
}