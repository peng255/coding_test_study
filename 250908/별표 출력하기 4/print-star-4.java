import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
    
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = n;

        for (int i = 1; i <= 2*n-1; i++){
            for (int j = 0; j < cnt; j++){
                System.out.print("* ");
            }
            System.out.println();

            if( i >= n){
                cnt ++;
            } else {
                cnt --;
            }
        }

    
    }
}