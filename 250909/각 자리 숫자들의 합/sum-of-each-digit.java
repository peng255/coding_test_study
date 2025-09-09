import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        int n = (new Scanner(System.in)).nextInt();

        String s = Integer.toString(n);

        int sum = 0;
        for (int i = 0; i < s.length(); i ++){
            // char -> String 바꿀 때 String.valueOf(_) 쓰기
            String letter = String.valueOf(s.charAt(i));
            sum += Integer.parseInt(letter);
        }

        System.out.print(sum);
    }
}