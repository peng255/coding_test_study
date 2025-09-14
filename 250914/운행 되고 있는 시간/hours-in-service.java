import java.util.Scanner;
public class Main {

    public static int[] start;
    public static int[] end;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        start = new int[n];
        end = new int[n];
        for(int i = 0; i < n; i ++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        int maxWork = 0;

        // i번째 개발자 제외
        for(int i = 0; i < n; i++){
            // i번째 제외한 개발자들 근무시간 표시
            int[] time = new int[1001]; // 제외하는 경우마다 근무기록 초기화
            for(int j = 0; j < n; j++){
                if(j==i) continue;
                for (int k = start[j]; k < end[j]; k++){
                    time[k] ++;
                }

                int workSum = 0;
                for(int k = 0; k < 1001; k++){
                    if(time[k] != 0)
                        workSum++;
                }
                maxWork = Math.max(maxWork, workSum);

            }
        }

        System.out.print(maxWork);
        
    }
}