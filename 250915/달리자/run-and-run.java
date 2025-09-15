import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n;
    
    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for(int i = 0 ; i < n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            b[i] = sc.nextInt();
  
        // 입력으로 주어진 사람 수를 보고
        // 최소 어느 만큼의 거리를 달려야 하는지 확인합니다.
        for(int i = 0; i < n; i++) {
            if(a[i] > b[i]) {
                // 최소 a[i] - b[i]명의 사람들은 오른쪽으로 달려야 합니다.
                int num = a[i] - b[i];
                a[i] -= num;
                a[i + 1] += num;
                ans += num;
            }
        }

        System.out.print(ans);
    }
}
