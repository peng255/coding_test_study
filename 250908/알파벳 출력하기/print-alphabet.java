import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
    
        int n = (new Scanner(System.in)).nextInt();

        char cnt = 'A';
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < i+1; j ++){
                System.out.print(cnt);
                cnt = next(cnt);
                
            }
            System.out.println();
        }
    }

    public static char next(char cnt){
        if((int)(cnt+1) > (int)'Z'){
            return 'A';
        }
        else return (char)(cnt +1);
    }
}