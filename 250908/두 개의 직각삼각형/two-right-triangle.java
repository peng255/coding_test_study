import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n=3 i=0일 때 별 n-i개=3
        // 공백 i개 *2

        for(int i = 0; i < n; i ++){
            // 왼쪽 반절 * 찍기
            for (int j = 0; j < n-i; j++){
                System.out.print("*");
            }
            // 왼쪽 오른쪽 * 사이 공백 
            for (int j = 0; j < 2*i; j++){
                System.out.print(" ");
            }
            // 나머지 오른쪽 별 개수
            for (int j = 0; j < n-i; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    
    }

}