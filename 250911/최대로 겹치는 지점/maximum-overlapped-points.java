import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        // 처음엔 0.. [0][1]~[100]
        int[] dot = new int[101];

        // n개의 선분들이 겹친 지점들을 dot[]에 표시
        for(int i = 0; i < n; i ++){
            for(int j=start[i]; j<= end[i]; j++){
                dot[j] += 1;
            }
        }

        int max = 0;
        int maxidx = 0;
        for (int i = 0; i < 101; i ++){
            if(max < dot[i]){
                max = dot[i];
                maxidx = i;
            }
        }

        System.out.println(max);
    }
}