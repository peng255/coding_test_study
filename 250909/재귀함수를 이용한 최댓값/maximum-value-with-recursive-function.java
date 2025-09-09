import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        System.out.println(recursion(arr, 0));

    }

    public static int recursion(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }

        int a = recursion(arr, idx+1);
        return  a > arr[idx] ? a : arr[idx]; 
    }
}