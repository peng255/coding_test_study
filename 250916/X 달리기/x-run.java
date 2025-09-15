import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 달리는 거리
        
        // 최단시간 구하기

        int currX = 1; //1초 이미 지났다고 생각
        int minTime = 1;
        int v = 1;
        while(true){
            if(currX >= x) break;
            
            // +1을 했을 때 속도..

            // +1을 한 속도에서 0으로 줄이기까지 가야하는 거리
            // (v+1) + v + ... +1 이 거리가 남은 거리보다 작거나 같아야 함
            int sum = 0;
            for(int i = v+1; i >=1; i--){
                sum += i;
            }
            if(sum <= (x-currX))
                v ++; // 남은 거리 안에 1까지 줄일 수 있으니 속도 올림
            else if((sum-(v+1)) <= x-currX){
                // 속도유지
            } else {
                v--; // 속도 줄이기
            }

            minTime ++;
            currX += v;
        }

        System.out.print(minTime);
    }
}