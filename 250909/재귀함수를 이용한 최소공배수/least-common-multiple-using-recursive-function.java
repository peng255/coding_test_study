import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        System.out.println(LCM(n-1,arr));
    }

    public static int LCM(int i,int[] arr){
        int curVal = arr[i];
        if(i==0) return curVal;
        
        //현재까지의 최소공배수와 나누어 떨어지면 더 큰값
        if(canDivide(curVal,LCM(i-1,arr))) return Math.max(curVal,LCM(i-1,arr));
        //나누어 떨어지지 않으면 두개를 곱한 값을 최대공약수로 나눔
        else return curVal*LCM(i-1,arr)/GCD(curVal,LCM(i-1,arr));
    }

    public static int GCD(int i,int j){
        if(i%j==0) return j;
        return GCD(j,i%j);
    }
    public static boolean canDivide(int i,int j){
        return i%j==0 || j%i==0;
    }
}

