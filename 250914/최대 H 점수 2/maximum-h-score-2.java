import java.util.*;
public class Main {

    public static boolean isValidH(int[] arr, int h){
        // System.out.println(Arrays.toString(arr));
        int cnt = 0;
        for(int i =0 ; i < arr.length; i++){
            if(arr[i]>= h){
                cnt++;
                // System.out.printf("cnt %d arr[i] %d\n", cnt, arr[i]);
                // h개 이상 있다는거 확인되면 조기 반환
                if(cnt>=h){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }        
        Arrays.sort(arr);

        int currH = 0;
        while(true){
            // System.out.printf("\n currH %d\n", currH);
            int startIdx = 0; 

            // currH - 1값을 가지는 첫 idx 찾기
            for(int i = 0; i < n; i ++){
                if(arr[i] == (currH-1)){
                    startIdx = i; 
                    break;
                }
            }

            // startIdx부터 l개 원소에 +1
            for(int i = 0; i < l; i++){
                if((startIdx+i)>=n) break;
                arr[startIdx + i] ++;
            }

            // System.out.printf("isValid %b\n", isValidH(arr, currH));

            if(isValidH(arr, currH)){
                for(int i = 0; i < l; i++){
                    if((startIdx+i)>=n) break;
                    arr[startIdx + i] --;
                }
                currH++; // 다음 h 찾기
            } 
            // h점수 안되는 h 발견 -> 답
            else {
                currH--; // 지금 직전의 h가 답이다
                break;
            }
        }        
        
        System.out.print(currH);
    }
}