import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
    
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = b < a ? b : a;
        min = c < min ? c : min;

        System.out.println(min);
    
    }
}