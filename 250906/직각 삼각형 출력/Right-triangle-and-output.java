import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i = 0; i < num; i++ ){ // 가로줄이 num개
		    
            // i=0 -> 한 줄에 2*0 + 1개 *
            for(int j = 0 ; j < (2*i +1); j++){
                System.out.print("*");
            }
            System.out.println();
            
        }
    }
}