import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 개발자 n명. 이름은 'A'부터 n개
        int n = sc.nextInt();
        // 나중에 메세지 읽은 개발자만 1로 표시하고 'A' + idx해서 출력 
        int[] developers = new int[n];
       
        // 메세지정보 m개 (시간순서대로)
        int m = sc.nextInt();
        // 안읽은 사람 이름을 구할 메세지 p번째
        int p = sc.nextInt();

        // 보낸사람 / 읽지 않은 사람 수
        char[] sender = new char[m];
        int[] unread = new int[m];
        for(int i = 0; i <m; i ++){
            sender[i] = sc.next().charAt(0);
            unread[i] = sc.nextInt();
        }

        if(unread[p-1] == 0){
            return;
        }

        for(int i = p-1; i < m; i ++){
            developers[sender[i]-'A'] ++;
        }

        for(int i = 0; i < n; i ++){
            if(developers[i] == 0){
                System.out.print((char)('A'+i) + " ");
            }
        }

    }
}