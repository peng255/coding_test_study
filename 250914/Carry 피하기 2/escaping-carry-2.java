import java.util.Scanner;
public class Main {
    public static boolean checkNotCarry(int a, int b, int c){

        // 계속 자릿수 없앨때 셋 중 하나는 0이 아닌채로 남아있는 한..
        while( !(a==0 && b==0 && c==0) ){
            if( ((a%10) + (b%10) + (c%10)) >= 10 ){
                return false;
            }
            a/=10;
            b/=10;
            c/=10;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // n개의 수 중 서로다른 3개 골랐을때 carry 되지 않으면서
        // 나올 수 있는 sum 최댓값 계산
        // 예) 21 + 35 = 5 6 으로 carry가 일어나지 않음
        

        int max = Integer.MIN_VALUE;
        boolean noCarry = false;
        for(int i = 0; i < n; i ++){
            for (int j = i +1; j < n; j++){
                for (int k = j +1; k < n; k++){
                    if(checkNotCarry(arr[i], arr[j], arr[k])){
                        max = Math.max(max, arr[i]+arr[j]+arr[k]);
                        noCarry = true;
                    }
                }
            }
        }
        // 모든 경우에서 carry가 발생하면 -1
        if(!noCarry){
            System.out.print(-1);
            return;
        }

        System.out.print(max);
    }
}