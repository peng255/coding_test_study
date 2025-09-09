import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String fst = sc.next();
        String snd = sc.next();

        String newString = fst.substring(0,2) + snd.substring(2);
        System.out.println(newString);

    }

}