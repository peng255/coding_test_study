import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 악수 k번까지 감염시킴
        int P = sc.nextInt(); // 처음 감염된 개발자
        int T = sc.nextInt(); // 총 악수횟수

        // 악수 행동 기록
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // 악수시점
            shakes[i][1] = sc.nextInt(); // 개발자1
            shakes[i][2] = sc.nextInt(); // 개발자2
        }
        // 악수시점 기준으로 정렬하기
        Arrays.sort(shakes, (a,b) -> a[0] - b[0]);
        for (int i = 0; i < T; i ++){
            // System.out.println(Arrays.toString(shakes[i]));
        }

        // 감염된 상태 0/1 N개발자
        int[] illness = new int[n+1];
        illness[P] = 1; // 처음 감염된 개발자

        // 감염 후 악수 횟수 
        int[] handshake = new int[n+1];

        // 시간 순대로 악수 진행하면서 상태 업데이트
        for (int i = 0; i < T; i ++){
            // 둘다 감염자 x 넘어가
            if (illness[shakes[i][1]]==0 && illness[shakes[i][2]]==0){
                continue;
            }

            // 둘 다 감염자라면 handshake에서 각자횟수 +1만 하고 continue
            if (illness[shakes[i][1]]==1 && illness[shakes[i][2]]==1){
                handshake[shakes[i][1]] ++;
                handshake[shakes[i][2]] ++;
                continue;
            }
            
            // 한 명만 감염자라면 int ill, int notIll에 인덱스 표시
            int ill, notIll;
            if (illness[shakes[i][1]]==1){
                ill = shakes[i][1];
                notIll = shakes[i][2];
            } else {
                ill = shakes[i][2];
                notIll = shakes[i][1];
            }

            // if handshake[ill] >= K 이제 감염 안됨. 그냥 넘어가
            if (handshake[ill] >= K ){
                continue;
            }
            // k번보다 적게 악수했다면 ill의 악수횟수 +1, illness[notIll] = 1
            handshake[ill] ++;
            illness[notIll] = 1;

        }

        for (int i = 1; i < n+1; i ++){
            System.out.print(illness[i]);
        }
    }
}