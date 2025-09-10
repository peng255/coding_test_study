import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.

        Arrays.sort(nums);
        int maxsum = Integer.MIN_VALUE;
        for (int i =0; i < n; i++){
            // System.out.println(i);
            // System.out.print("nums[i] " + nums[i] + " nums[n-i-1] " + nums[n-i-1] + "\n");
            if (maxsum < nums[i] + nums[2*n-i-1]){
                // i = 0일때 num[2n-1]이랑 그룹
                // i = 1일때 num[2n-2]
                maxsum = nums[i] + nums[2*n-i-1];
                
            }
        }
        System.out.print(maxsum);

        // System.out.print(Arrays.toString(nums));
    }
}