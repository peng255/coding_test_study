import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();

        System.out.println(s.charAt(0) + "a" + s.substring(2, (s.length()-2)) + "a" + s.charAt(s.length()-1));
    }
}