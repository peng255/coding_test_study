import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a/b);
        System.out.print(".");

        for (int i = 0; i < 20; i++){
            a = a % b * 10;
            System.out.print(a/b);
        }
        
    
    }
}