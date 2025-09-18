import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1 ; i <= n; i ++){
            dq.addLast(i);
        }

        while(dq.size()>1){
            dq.pollFirst(); //맨 앞 정수 제거
            dq.addLast(dq.pollFirst()); //맨앞 정수를 뒤에 넣음
        }

        System.out.print(dq.pollFirst());
    }
}