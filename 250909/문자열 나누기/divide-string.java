import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = "";
        for (int i = 0; i < n; i ++){
            s+= sc.next();
        }  

        // System.out.println(s);

        int idx = 0;
        for (int i = 0; i < s.length(); i ++){
            System.out.print(s.charAt(i));
            if((i+1)%5 == 0){
                System.out.println();
            }
        }
    }
}