import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        // n 받기
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // j=0,2,4.. 짝수일때는 하나만 프린트
        // j=1 -> i=0,1까지
        // j=3 -> i=0,1,2,3까지
        

        for (int i=0; i < n; i ++){
            for (int j =0; j < n; j ++){
                // 첫째 가로줄은 다 프린트
                if(i==0){
                    System.out.print("* ");
                } 
                // 두번째줄부터.. j가 홀수일때는 i<=j이면 프린트
                else if( j%2 != 0 && i <=j) {
                    System.out.print("* ");
                }
                // 위 조건이 아니라면 공백으로 칸 채우기
                else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    
    }
}