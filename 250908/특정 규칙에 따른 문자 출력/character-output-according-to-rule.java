import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        // n=3, i=0일때 공백 n-i-1 별 i+1
        // ~ i<n까지
        for (int i = 0; i < n; i++){

            for (int j = 0; j < n-i-1; j ++){
                System.out.print("  ");
            }
            for (int j = 0; j < i+1; j++){
                System.out.print("@ ");
            }
            System.out.println();
        }


        // n=3, i=0일때 별 n-i-1개
        // ~ i<n-1까지

        for (int i = 0; i < n-1; i++){

            for (int j = 0; j < n-i-1; j++){
                System.out.print("@ ");
            }
            System.out.println();
        }
    }
}