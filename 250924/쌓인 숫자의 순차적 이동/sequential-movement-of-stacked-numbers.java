import java.util.*;

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static LinkedList<Integer>[][] grid;
    public static Stack<Integer> stack = new Stack<Integer>(); // 옮길 숫자를 임시로 담는 스택
    public static Coordinate[] indexArr;
    public static int[][] maxArr;
    public static final int DIR_NUM = 8;
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 윗줄 3칸, 좌우, 아랫줄 3칸
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n*n 개의 숫자
        m = sc.nextInt(); // 숫자 움직임 횟수
        grid = new LinkedList[n][n]; // 숫자가 쌓인 상태로 된 판 상태
        
        indexArr = new Coordinate[n*n + 1]; // arr[i]에는 숫자 i의 좌표 (x, y)가 있음
        maxArr = new int[n][n]; // [i][j] 칸에 쌓인 숫자 중 max를 업데이트. 숫자 없으면 0

        // 입력받은 숫자 정보 채워넣는 단계
        for(int i= 0 ; i < n; i ++){
            for(int j = 0; j < n; j++){
                grid[i][j] = new LinkedList<>(); // 각 칸에 LinkedList 객체 생성
                int num = sc.nextInt();
                grid[i][j].add(num);

                // 방금 입력받은 수의 좌표정보 저장
                indexArr[num] = new Coordinate(i, j);
                maxArr[i][j] = num;
            }
        }

        for(int move = 0; move < m; move++){
            int moveNum = sc.nextInt();

            simulate(moveNum);
        }

        print();
    }

    // grid[i][j] 칸의 max값을 업데이트
    public static void updateMax(int i, int j){
        int max = 0;
        for(int num : grid[i][j]){
            if(max < num)
                max = num;
        }
        maxArr[i][j] = max;
    }

    public static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static void simulate(int moveNum){
        int x = indexArr[moveNum].x;
        int y = indexArr[moveNum].y; // 가운데 기준 좌표
        
        // 주변 숫자 중 max숫자 좌표를 찾기 위한 변수
        int maxX = 0;
        int maxY = 0;
        int nx, ny;
        int maxValue = 0;

        // 주변 8칸 봤을 때 max값이 가장 큰 칸 [nx][ny]
        for(int i = 0; i < DIR_NUM; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            // System.out.printf("nx %d ny %d\n", nx, ny);

            if( inRange(nx, ny) && (maxArr[nx][ny] > maxValue)){
                maxX = nx;
                maxY = ny;
                maxValue = maxArr[nx][ny];
            }
        }
        if( maxValue == 0 ){
            // 8칸 봤는데도 max값이 0이면 주변 다 0. 안움직임
            return;
        }

        // moveNum를 포함해서 그 전에 있는 숫자들을 [nx][ny]의 앞에 추가하기
        while(true){
            LinkedList<Integer> ptr = grid[x][y];
            int first = ptr.pollFirst();
            stack.push(first); // 옮길 숫자들을 스택에 저장

            // 방금 맨앞에서 꺼낸게 우리 타겟 숫자면 while 탈출
            if(first == moveNum)
                break;
        }

        // 스택에서 다시 꺼내서 옮길 칸의 앞에 추가
        while(!stack.empty()){
            int pop = stack.pop();
            grid[maxX][maxY].addFirst(pop);
            // 숫자 옮겼으면 그 숫자의 indexArr도 업데이트하기!!
            indexArr[pop].x = maxX;
            indexArr[pop].y = maxY;
        }

        // 숫자를 옮긴 두 칸의 max를 업데이트
        updateMax(x, y);
        updateMax(maxX, maxY);


    }

    public static void print(){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j].size() == 0){
                    System.out.println("None");
                    continue;
                }
                // LinkedList 값 하나하나 프린트할 때 인덱스 몰라도 그냥 iterator 이용
                for(int num : grid[i][j]){
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            
        }
    }
}