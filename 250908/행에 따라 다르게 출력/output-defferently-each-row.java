import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        int n = (new Scanner(System.in)).nextInt();

        int cnt = 0;

        for (int i =0 ; i < n; i ++){
            for (int j = 0; j < n; j ++){
                if (i%2 == 0){
                    cnt += 1;
                }
                else {
                    cnt += 2;
                }
                System.out.print(cnt + " ");
            }
            System.out.println();
        }
    
    }
}