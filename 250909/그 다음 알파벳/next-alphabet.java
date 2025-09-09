import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        char c = (new Scanner(System.in)).next().charAt(0);

        if(c=='z'){
            System.out.print('a');
        } else {
            System.out.print((char)(c + 1));
        }
    }
}