import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        int posCnt = 0;
        int negCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > 0)
                posCnt ++;
            else if(arr[i] < 0)
                negCnt ++;
            else if(arr[i] == 0)
                zeroCnt ++;
        }

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        int lastNeg = -1;
        int fstPos = -1;
        if(arr[0] > 0){
            fstPos = 0; //정렬 후 첫번째가 양수라면 가장 작은 양수위치 0
        } else if (arr[n-1] < 0){
            lastNeg = n-1; // 정렬 후 맨 오른쪽이 음수라면 모두 음수임
        } else {
            for(int i = 0; i < n-1; i ++){
                if(arr[i]<0 && arr[i+1]>=0){
                    lastNeg = i;
                }
                if(arr[i]<=0 && arr[i+1]>0){
                    fstPos = i+1;
                }
                // 마지막 음수와 첫 양수 둘다 찾았으면 더 돌지 x
                if(lastNeg!=(-1) && fstPos!=(-1))
                    break;
            }
        }
        // System.out.printf("fstpos %d lastneg %d\n", fstPos, lastNeg);
        
        int result1, result2, result3, result4, result5;
        result1 = Integer.MIN_VALUE;
        result2 = result3 = result4 = result5 = result1;
        if(posCnt >= 3){
            // System.out.printf("case1\n");
            result1 = arr[n-1] * arr[n-2] * arr[n-3];
        }
        if(posCnt >= 1 && negCnt >=2){
            // System.out.printf("case2\n");
            // 제일큰(+) * 절댓값 제일큰 음수 2개
            result2 = arr[n-1] * arr[0] * arr[1];
        } 
        if(zeroCnt > 0){
            // System.out.printf("case3\n");
            result3 = 0;
        } 
        if(posCnt==2 && negCnt==1){
            // System.out.printf("%d %d %d\n", arr[fstPos], arr[fstPos+1], arr[lastNeg]);
            result4 = arr[fstPos] * arr[fstPos+1] * arr[lastNeg];
        } 
        if(negCnt >= 3) { // 절댓값 젤 작은 음수 3개
            // System.out.printf("case5\n");
            result5 = arr[lastNeg] * arr[lastNeg-1] * arr[lastNeg-2];
        }
        // System.out.printf("%d %d %d %d %d\n", result1, result2, result3, result4, result5);
        int result = Math.max(Math.max( Math.max(result1, result2), Math.max(result3, result4)), result5);
        System.out.print(result);

    }
}