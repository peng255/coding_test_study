import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int sizeA = sc.nextInt();
        int sizeB = sc.nextInt();

        int[] a = new int[sizeA];
        int[] b = new int[sizeB];

        for (int i = 0; i < sizeA; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < sizeB; i++){
            b[i] = sc.nextInt();
        }

        int[] idx = new int[sizeA];
        int idxCnt = 0;
        for (int i = 0; i < sizeA; i++){
            // B의 첫 원소가 A에서 등장하는 인덱스 저장
            if ( a[i] == b[0] ){
                idx[idxCnt] = i;
                idxCnt++;
            }
        }

        boolean isSub = false;
        // i는 B가 등장한 인덱스
        for (int i = 0; i < idxCnt; i ++){
            // j는 B가 등장한 인덱스에 하나씩 증가시키는 용도
            for (int j = 0; j < sizeB; j ++){
                // a[idx1 + 0] == b[0]
                // a[idx1 + 1] == b[1]...
                // System.out.println("a[i+j]: " + a[idx[i]+j] + " b[j]: " + b[j]);
                if( a[idx[i]+j] != b[j]) {
                    break;
                }
                // B를 전체 다 돌때까지 통과했으면 true
                if(j==sizeB-1){
                    isSub = true;
                }
            }

            // 부분수열 하나 찾았으면 break
            if(isSub){
                break;
            }
           
        }

        System.out.println(isSub?"Yes":"No");

    }
}