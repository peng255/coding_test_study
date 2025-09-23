import java.util.*;
public class Main {
    public static int n, startX, startY, currX, currY, dir;
    public static int totalTime = 0;
    public static char[][] maze;
    public static int[] dx = {0, 1, 0, -1}; // 오른 아래 왼 위
    public static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        startX = sc.nextInt();
        startY = sc.nextInt();
        startX--; startY--; // index로 쓸 수 있게 보정
        
        currX = startX; // currX, currY로 현재 위치 관리
        currY = startY;
        dir = 0; // 처음에는 무조건 오른쪽 이동 방향

        maze = new char[n][n];
        for(int i = 0; i < n; i ++){
            String line = sc.next();
            for(int j = 0; j < n; j++){
                maze[i][j] = line.charAt(j);
            }
        }

        int nx, ny;

        while(true){
            nx = currX + dx[dir];
            ny = currY + dy[dir];
            // 현재 방향 앞이 벽인 동안에 계속 회전
            int breakCnt = 0;
            while(inRange(nx, ny) && maze[nx][ny] == '#'){
                if(breakCnt==5){ // 제자리에서 계속 돌면 -1 출력하고 종료
                    System.out.println(-1);
                    System.exit(0);
                }
                dir = rotateAntiClock();
                breakCnt ++;
                nx = currX + dx[dir]; // 이동할 좌표 다시 구함
                ny = currY + dy[dir]; 
            } // 빠져나오면 이제 dir방향 앞에 벽 없음
            // System.out.printf("다음좌표 nx %d ny %d\n", nx, ny);

            // dir방향으로 한칸 좌표가 range를 넘어가면 이동 후 탈출
            if( !inRange(nx, ny) ){
                // System.out.println("탈출");
                // 다음 이동할 칸이 out of bound이므로 .. time만 증가시키고 실제로 x y 업데이트x
                totalTime ++;
                System.out.println(totalTime);
                return;
            }
            else {
                // dir방향으로 한칸 이동 후 오른쪽 칸의 좌표 nnx, nny
                int nnx = nx + dx[ rotateClock() ]; // dir자체는 변하지 않음
                int nny = ny + dy[ rotateClock() ]; // 현재 dir의 시계방향 번호값만 받아옴
                // System.out.printf("nnx %d nny %d\n", nnx, nny);

                if( maze[nnx][nny] == '#' ){
                    // System.out.printf("오른쪽에 벽 있음\n");
                    move();
                }
                else { // 이동할 칸 오른쪽에 벽이 없으면 .. 이동-회전-이동
                    // System.out.printf("오른쪽에 벽 없음\n");
                    move();
                    dir = rotateClock(); // dir 시계방향 돌린걸로 업데이트
                    move();
                    // System.out.printf("코너 돈 후에 x %d y %d\n", currX, currY);
                }
            }

            if(currX == startX && currY == startY && dir == 0){
                System.out.print(-1);
                System.exit(0);
            }

        } 
        // 한번 실행 후 다시 시작지점으로 돌아온다면 탈출불가임을 인식하고 while 멈춤
        // 탈출할 수 있다면 시작지점으로 돌아오기 전에 break할 수 있다

        // System.out.print(totalTime);

    }

    public static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static int rotateClock(){
        // 0 1 2 3 0 1...
        return (dir + 1) % 4;
    }
    public static int rotateAntiClock(){
        // 0 3 2 1 0 3 2 1...
        return (dir + 3) % 4;
    }

    // dir방향으로 한 칸 이동
    public static void move(){
        currX += dx[dir];
        currY += dy[dir];
        totalTime ++;
    }

    public static void print(char[][] arr){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}