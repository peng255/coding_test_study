import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int M = 0;
        int L = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            M = Math.max(M, arr[i]);
            L = Math.min(L, arr[i]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = L; i<=M; i++) {
            int j = i + k;
            if (j<= 10000) {
                    int cost = 0;
                    for (int z = 0; z<n; z++) {
                        if (arr[z] > j || arr[z] < i){
                            cost += Math.min(Math.abs(arr[z] - i), Math.abs(arr[z] - j));
                        }
                    }
                    if (cost < min) {
                        min = cost;
                    }
            }
        }

        System.out.print(min);
    }
}
