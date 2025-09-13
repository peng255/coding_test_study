import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 집 개수 
        int[] people = new int[n]; // n개의 집 각각에 살고있는 사람 수
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int sum=0;
        // 기준점이 되는 집 idx i
        for (int i=0; i < n; i ++){
            sum = 0;
            // 기준점에 대해 n개 집의 이동거리 구하기 위한 for문
            for (int j = 0; j<n; j ++){
                // 거리에 절댓값 이용하기
                sum += (Math.abs(j-i) * people[j]);
            }

            if(sum < min){
                min = sum;
            }
        }

        System.out.println(min);
    }
}