import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] data = new int[size];
        for (int i = 0; i < size; i ++){
            data[i] = i+1;
        }

        int[][] result = new int[size][size];

        // i=0 세로줄로 생각 -> [0 1 2..][i]를 채움
        for (int i = 0; i < size; i ++){
            
            for(int j = 0; j < size; j++ ){
                if ( i % 2 == 0 ){ // 짝수 세로줄 1 2 3 4 ..
                    result[j][i] = data[j];
                }
                else { // 홀수 세로줄 4 3 2 1 ..
                    result[j][i] = data[size-j-1];
                }
            }
            
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}