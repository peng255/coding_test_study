import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.

        // A일 B시 C분이 11일 11시 11분보다 빠르다면 -1
        if( A<11 || (A==11 && B<11) || (A==11 && B==11 && C<11)){
            System.out.println(-1);
            return;
        }

        // 11월 1일 0시 0분 ~ 11월 11일 11시 11분까지의 min 구하기
        int startDateMin = 11 + 11*60 + 10*24*60;

        // 11월 1일 0시 0분 ~ 11월 A일 B시 C분까지의 min 구하기
        int endDateMin = C + B*60 + (A-1)*24*60;

        System.out.println(endDateMin - startDateMin);

    }
}