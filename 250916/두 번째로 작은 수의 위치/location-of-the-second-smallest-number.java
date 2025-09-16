import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 두번째로 작은 수의 위치 출력
        // n은 2이상
        // 두번째로 작은 수가 없거나 여러개 있으면 -1 출력

        // 최솟값 찾기. 인덱스 상관없이 
        int fstMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            if(arr[i] < fstMin){
                fstMin = arr[i];
            }
        }

        // fstMin보다 큰 수 중에 제일 작은 수 / 인덱스 찾기
        int sndMin = Integer.MAX_VALUE;
        boolean multiple = false;
        int idx = -1;        
        for(int i = 0; i < n; i ++){
            // 현재 찾은 값중에 제일 작지만 fstmin보다는 큰 수 
            if(arr[i]>fstMin && arr[i]<sndMin){
                sndMin = arr[i];
                idx = i;
            }
        }
        if( idx == -1){
            // fstmin보다 큰 최솟값 못찾음
            System.out.print(-1);
            return;
        }

        // sndmin이 2개이상이면 -1 출력
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(arr[i]==sndMin){
                cnt++;
            }
        }
        if(cnt >= 2){
            System.out.print(-1);
            return;
        }

        // 2개 이상도 아니고 존재하지않는 것도 아니면 idx 출력
        System.out.print(idx+1); // [1]이면 두번째 위치
        
    }
}