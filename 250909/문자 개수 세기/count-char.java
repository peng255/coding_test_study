import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        char c = sc.next().charAt(0);
        // System.out.println(sc.next());

        int cnt = 0;
        for (int i = 0 ; i < sentence.length(); i ++){
            if( sentence.charAt(i) == c ){
                cnt++;
            }
        }

        System.out.println(cnt);
    
    }
}