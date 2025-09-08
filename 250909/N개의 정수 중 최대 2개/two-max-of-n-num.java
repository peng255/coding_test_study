import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int fstMax = Integer.MIN_VALUE;
        int sndMax = Integer.MIN_VALUE;

        for ( int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
            
            // 새로 들어온 수가 최대보다 크면
            // fstMax를 그 수로 하고
            // sndMax에 fstMax 값을 넣는다
            if ( arr[i] > fstMax ){
                sndMax = fstMax; 
                fstMax = arr[i];
            }
            // fstMax보다는 안 크지만 sndMax보다는 클 때
            else if (arr[i] > sndMax){
                sndMax = arr[i];
            }
        }

        System.out.println(fstMax + " " + sndMax);
    }
}