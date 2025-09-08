import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            // 100배수 o 400배수 x ->  평년
            if( (i % 100 == 0) && (i%400 != 0) ){
                continue;
            } 
            // 4배수 o -> 윤년
            else if ( i% 4 == 0){
                cnt +=1;
            }
            // 나머지 -> 평년
            else {
                continue;
            }
        }

        System.out.print(cnt);
        
    }
}