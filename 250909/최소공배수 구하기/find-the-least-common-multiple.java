import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        for (int i = Math.max(n,m); i <= n*m; i ++){
            if (i%n == 0 && i%m == 0){
                System.out.print(i);
                return;
            }
        }
    }
}