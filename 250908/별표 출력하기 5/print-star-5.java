import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // i : 3,2,1
        for (int i = n; i >0; i--){
            for (int j = 0; j < i; j++){
                for (int k = 0; k <i; k++){
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    
    }
}