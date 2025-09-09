import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }

        // 최대이익 초기세팅 0
        int maxProfit = 0;

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i ++){
            
            // 새로 확인하는 수가 max보다 크면 max 업데이트
            if(arr[i] > max){
                max = arr[i];
                // 수익 다시 계산해보기. 기존 최대수익보다 안 크면 그대로 둠
                if( max - min > maxProfit){
                    maxProfit = max-min;
                }
            }

            // min보다 작은 수 등장하면 그걸로 교체
            else if (arr[i] < min){
                min = arr[i];
                max = arr[i]; // min이전에 있는 최대값은 의미x 다시 세팅
            }

        }
        System.out.println(maxProfit);
    }
}