import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        // j 짝수 세로줄
        // (0,0) -> 1
        // (1,0) -> 2
        // i+1을 프린트하기

        // j 홀수 세로줄
        // n-i를 프린트하기

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i =0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                if (j%2 == 0){
                    System.out.print(i+1);
                } else {
                    System.out.print(n-i);
                }
            }
            System.out.println();
        }


    }
}