import java.util.Scanner;
public class Main {
    public static final int MAX_NUM = 100; // 바구니 최대개수

    public static int n; // 바구니 개수
    public static int k; // 양쪽 범위 
    public static int[] arr = new int[MAX_NUM + 1]; // 0~100까지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); //바구니 개수
        k = sc.nextInt(); // 범위

        for(int i = 0; i < n; i ++){
            int candy = sc.nextInt();
            int idx = sc.nextInt();

            arr[idx] += candy; //그냥 대입하는게 아니라 더해주긔
        }

        int maxSum = 0; //사탕개수 양수니까 젤작은 개수는 0

        for(int i = 0; i <= MAX_NUM; i++){
            int sum = 0; // 구간 내에 캔디 수 합

            // i-k ~ i+k 훑기
            for(int j = i-k; j <= i+k; j++){
                
                // 0~100 안에 있는 인덱스일때만 더함
                if( j>=0 && j<=MAX_NUM)
                    sum += arr[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);

    }
}