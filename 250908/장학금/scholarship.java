import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        // 중간고사 90점 이상이어야 고려

        // 기말고사 점수가 95점 이상 -> 10만원
        // 기말고사 점수가 90점 이상 -> 5만원 
        // 나머지는 0원

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if ( a < 90){
            System.out.print(0);
        } else if (b >= 95){
            System.out.print(100000);
        } else if (b >= 90){
            System.out.print(50000);
        } else {
            System.out.print(0);
            
        }
    }
}