import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2011. 01. 01을 기준으로 2011.m1.d1.까지의 날짜 수 구하기
        int cnt1 = 0;
        for (int i = 0; i < m1-1; i ++){
            cnt1 += days[i];
        }
        cnt1 += d1-1;

        int cnt2 = 0;
        for (int i = 0; i < m2-1; i ++){
            cnt2 += days[i];
        }
        cnt2 += d2-1;

        String[] yoil = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int diff = cnt2 - cnt1;
        if (diff < 0){
            diff += 7;
        }
        
        System.out.println(yoil[ diff%7 ]);


    }
}