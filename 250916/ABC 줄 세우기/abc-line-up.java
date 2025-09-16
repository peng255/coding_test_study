import java.util.*;
public class Main {

    public static char[] arr;

    public static void exchange(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        int exCnt = 0;
        // letter=0이면 'A'. 
        for(int letter = 0; letter < n; letter++){
            // letter번째 알파벳을 찾기만 하는 for문
            int foundIdx = -1;
            for(int i = 0; i < n; i++){
                if(arr[i] == (char)('A'+letter)){
                    foundIdx = i;
                    break;
                }
            }

            if( foundIdx == letter ){ // 알파벳이 자기자리에 있음
                continue; // 다음 알파벳 찾으러 이동
            } 
            else {
                // ABEDC라면 C를 정렬하기 위해 4<->3, 3<->2 바꿔야 함
                for(int i = foundIdx; i > letter; i--){
                    // exchange(arr[i], arr[i-1]);
                    char temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    exCnt ++;
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
        System.out.print(exCnt);
    }
}