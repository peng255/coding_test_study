import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int arr[] = new int[n/2 + 1];

        int cnt=0;
        while(true){
            if(n < b){
                arr[cnt++] = n;
                break;
            }

            arr[cnt++] = n%b;
            n /= b;

        }

        for (int i = cnt-1; i >=0; i --){
            System.out.print(arr[i]);
        }
    }
}