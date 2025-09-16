import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] % 2 == 0) {
                even++;
            }
            else {
                odd++;
            }
        }

        // 짝수 개수 > 홀수 개수
        if (even > odd) {
            System.out.print(odd * 2 + 1);
        }

        // 짝수 개수 == 홀수 개수
        else if (even == odd) {
            System.out.print(odd);
        }

        // 홀수 개수 > 짝수 개수
        else {
            int count = even * 2 + (((odd-even) / 3) * 2); // 3 => (짝수(홀수 2개) + 홀수(홀수1개))
            int a = (odd-even) % 3;
            if (a == 2) {
                count += 1;
            }
            else if (a == 1) {
                count -= 1;
            }

            System.out.print(count);
        }
    }
}
