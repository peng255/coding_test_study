import java.util.*;

public class Main {

    public static int n, m;
    public static int[] bombs;
    public static int[] temp;

    public static int cntBomb;
    public static boolean deleteBomb(){
        boolean deleted = false; // 뒤에서 변경되지 않는다면 중복된 폭탄없음

        // if(cntBomb == 1 && m==1){
        //     cntBomb = 0;
        //     return false;
        // }
        // [0]~[n-m]을 시작점으로 m개를 확인하고, 모두 같으면 0으로 수정
        for(int i = 0; i <= n-m; i ++){
            // System.out.println("i = "+ i);
            boolean allsame = true;
            for(int j = 0; j < m; j++){ // m=2이면 [0]이랑 [0][1] 비교
                // System.out.println("j = "+j);
                if((bombs[i]==0) || (bombs[i]!=bombs[i+j]))
                    allsame = false; // 기준이 0이거나 연속된 m개 다른거 있으면 폭탄 터지지x
            }
            if(allsame){ // 연속된 게 모두 같은 게 있는 경우
                deleted = true;
                int j = 1;
                // && 조건 앞뒤 바뀌면 [i+j]먼저 접근해서 outof bound 에러 나니 주의
                while((i+j < n) && (bombs[i] == bombs[i+j])){
                    bombs[i+j] = 0; //연속된 블럭들 0으로 수정
                    cntBomb --; // 개수 줄이기
                    j++; // m이 2여도 연속된게 3,4개 이러면 걔네 다 터져야 함
                }
                bombs[i] = 0; // 기준칸 0으로 마지막에 설정. 미리 0으로 두면 위에서 == 비교가 안됨
                cntBomb--;
                // System.out.println(Arrays.toString(bombs));
            }
        }

        if(deleted == false)
            return deleted; // 변경된 거 없으면 조기 리턴

        // 아래로 쭉 내린 결과배열
        temp = new int[n];
       
        int nextIdx = 0; 
        for(int i = 0; i < n; i++){
            // 0 아닌것만 temp에 쌓음
            if(bombs[i] != 0){
                temp[nextIdx++] = bombs[i];
            } 
        }

        // temp -> bombs로 복사하기
        for(int i = 0; i < n; i++){
            bombs[i] = temp[i];
        }

        return deleted;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cntBomb = n; // 총 폭탄 개수 기록
        bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        
        // 중복된거 없을때까지 delete 돌림
        while(true){
            boolean result = deleteBomb();
            // System.out.println(Arrays.toString(bombs));
            if( result == false ){
                break;
            }
        }

        System.out.println(cntBomb);
        if(cntBomb != 0){
            for(int i = 0; i < cntBomb; i ++){
                System.out.println(bombs[i]);
            }
        }
        
    }
}