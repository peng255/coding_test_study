import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 0; i < num; i++ ){ // 가로줄이 num개
            for (int j = num-i; j > 0; j--){ // i=0일때 num번 * 출력
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}