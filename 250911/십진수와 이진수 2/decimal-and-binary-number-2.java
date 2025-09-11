import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binary = sc.nextInt();

        int decimal = toDecimal(binary);
        decimal *= 17;

        toBinary(decimal);
    }

    public static int toDecimal(int n){
        int decimal = 0;
        int cnt = 0;
        // 10으로 나눈 나머지에 2^cnt를 곱해서 decimal에 더함
        // decimal을 10으로 나누고 반복
        // decimal이 1이하가 되면 2^cnt를 곱해서 decimal에 더하고 탈출 
        while(true){
            decimal += Math.pow(2, cnt)*(n%10);
            // System.out.println(decimal);

            if(n<2){
                break;
            }
            n /= 10;
            cnt++;
        }
        return decimal;

    }

    public static void toBinary(int n){
        int[] result = new int[n/2 +1];
        int cnt = 0; // 2진수 몇자리인지 세기

        // 2로 나눈 나머지 기록
        // n을 2로 나누기
        // n <= 1이 되면 기록하고 break
        while(true){
            if(n<2){
                result[cnt++] = n;
                break;
            }
            result[cnt++] = n%2;
            n /= 2;
        }

        // 만들어진 int[]를 cnt-1부터 역순으로 출력
        for (int i = cnt-1; i >=0; i --){
            System.out.print(result[i]);
        }
    }
}