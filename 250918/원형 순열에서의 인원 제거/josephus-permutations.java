import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n명
        int k = sc.nextInt(); // k번째 사람 제거
        // 시작지점 1, 그다음 2, 3, 4..

        Queue<Integer> q = new LinkedList<>();
        // 1~n 들어있는 큐 초기화
        for(int i = 1; i <= n;  i++){
            q.add(i);
        }

        // k번째 꺼내면서 프린트 
        while( q.size() > 1){
            for(int i = 0; i < k-1; i ++){
                q.add(q.poll());
            }
            System.out.print(q.poll() + " ");
        }
        System.out.print(q.poll());
    }
}