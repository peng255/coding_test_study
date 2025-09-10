import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here
    
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String word3 = String.valueOf(c1);
        String word4 = String.valueOf(c2);

        if(word3.equals(word4)){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}