import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        String a = sc.next().trim();
        String b = sc.next().trim();

        if ( a.length() > b.length() ){
            System.out.println(a + " " + a.length());
        } else if (a.length() == b.length()){
            System.out.println("same");
        } else {
            System.out.println(b + " " + b.length());
        }
    }
}