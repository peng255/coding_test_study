import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        int n = (new Scanner(System.in)).nextInt();
        if (n==1){
            return;
        }
        if (n==2){
            System.out.println(2);
            return;
        }

        System.out.print(2 + " ");

        for (int i = 3; i <= n; i ++){
            
            boolean prime = true;

            for (int j = 2; j<i; j++){
                // i를 2~i-1로 나눠봤을 때 나머지 0인 경우가 없으면 소수
                // System.out.println("i: " + i + " j: " + j);
                // System.out.println("i%j = " + i%j);
                if (i%j == 0 ){
                    prime = false;
                    break;
                }
            }
            // System.out.print("prime " + prime);

            if (prime) { // 0이면 i가 소수
                // System.out.println("is prime");
                System.out.print(i + " ");
            }
        }
    }
}