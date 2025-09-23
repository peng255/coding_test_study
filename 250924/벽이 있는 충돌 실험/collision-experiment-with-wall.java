import java.util.*;
import java.io.*;

// 한 점의 현재 위치, 진행방향 정보를 객체에 묶어서 저장
class point{
    int row;
    int col;
    int dir;
    public point(int row, int col, int dir){
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    // 아래의 equals, hashCode는 set.remove(), set.contains()내부에서 필요한듯
    @Override
    public boolean equals(Object o){
        if (this == o) return true; //주소값 비교
        // 비교하는 객체가 null이거나 point 클래스가 아니면 false
        if(o == null || getClass() != o.getClass()) return false;
        point p = (point) o; // point클래스인걸 위에서 확인했으니 캐스팅
        return row==p.row && col==p.col; // row col이 같으면 같은 point로 간주
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class Main {
    public static final int MAX_LENGTH = 100;
    public static HashSet<point> pointSet = new HashSet<>();
    public static HashSet<point> removeSet = new HashSet<>();

    public static Queue<point> q = new LinkedList<>();
    public static int[] arrRow = {-1, 0, 1, 0}; // 위 오른 아래 왼
    public static int[] arrCol = {0, 1, 0, -1};

    public static boolean inRange(int row, int col, int width){
        return row >=1 && col>=1 && row<=width && col<=width;
    }

    public static int simulation(int N){
        // 4N만큼 반복하면 충분히 많은 시간이 지난거다?
        for(int i = 0; i < 4*N; i++){
            for(point p : pointSet){
                // 현재 방향으로 한칸 간 좌표를 일단 계산
                int preRow = p.row + arrRow[p.dir];
                int preCol = p.col + arrCol[p.dir];
                if(inRange(preRow, preCol, N)){
                    // range를 벗어나지 않는다면 큐q에 움직였을때의 point를 추가
                    q.add(new point(preRow, preCol, p.dir));
                } else {
                    // range를 벗어난다면 좌표이동x 방향만 반대로 바꾼다. 0<->2, 1<->3
                    q.add(new point(p.row, p.col, (p.dir+2)%4));
                }
            }
            pointSet.clear(); // 기존 구슬 정보가 있던 pointSet을 비운다

            // queue 에서 구슬을 꺼내면서.. 좌표에 구슬이 없으면 pointSet에, 있으면 removeSet에 추가한다
            while(!q.isEmpty()){
                point curPoint = q.poll(); // 앞에서 꺼냄
                if(pointSet.contains(curPoint)){ // 이미 같은 좌표인 객체가 set에 있다면
                    //제거해야할 set에 넣음. 나중에 그 자리에 있는 애도 없앨 것
                    removeSet.add(curPoint);
                } else {
                    pointSet.add(curPoint);
                }

                // removeSet에 있는 구슬과 같은 좌표를 가진 객체를 pointSet에서 제거
                for(point p : removeSet) {
                    pointSet.remove(p);
                }
                removeSet.clear(); // 초기화
            }
        }

        int answer = pointSet.size(); // 4N만큼 구슬 움직인 후 남은 개수 리턴
        pointSet.clear(); // 다음 테스트케이스를 위해 초기화
        return answer;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // testcase 개수
        for(int i = 0; i < T; i ++){
            // testcase에서 주어지는 초기상황 한줄 읽어서 공백기준으로 쪼갬
            st = new StringTokenizer(br.readLine(), " "); 
            int N = Integer.parseInt(st.nextToken()); // 판의 크기
            int M = Integer.parseInt(st.nextToken()); // 구슬 개수. 아래로 초기 위치 입력됨
            
            // M개의 구슬 위치, 방향 입력받으면서 HashSet pointSet에 저장
            for(int j = 1; j <=M; j++){
                st = new StringTokenizer(br.readLine(), " "); // 새 토크나이저로 받아옴
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                // String.valueOf(토큰)으로 받고 charAt(0)으로 char로 바꿈! 참고
                char dir = String.valueOf(st.nextToken()).charAt(0);
                // 방향 문자를 숫자로 대치시키기
                int dirNum = 0;
                if(dir == 'U')
                    dirNum = 0;
                else if(dir == 'R')
                    dirNum = 1;
                else if(dir == 'D')
                    dirNum = 2;
                else    
                    dirNum = 3;
                
                // 구슬의 현재 구성정보를 담은 set에 구슬point 객체를 만들어서 추가
                pointSet.add(new point(row, col, dirNum));
            }
            System.out.println(simulation(N)); //simulation(N) 결과로 나온 구슬 개수를 출력
        }

    }
}