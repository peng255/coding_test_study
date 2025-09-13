import java.util.*;
public class Main {

    public static int toDecimal(String binary){
        int len = binary.length();
        int sum = 0;
        for (int i = 0; i < len; i ++){
            sum = sum*2 + Integer.parseInt(binary.substring(i, i+1));
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();

        int max = Integer.MIN_VALUE;
        int len = binary.length();
        for(int i = 0; i < len; i ++){
            // i번째 문자가 0이라면 1, 1이라면 0을 저장
            String add = binary.substring(i,i+1).equals("0") ? "1" : "0";
            String newBinary = binary.substring(0, i) + add + binary.substring(i+1, len);
            int decimal = toDecimal(newBinary);
            // System.out.printf("%s %d\n", newBinary, decimal);
            if(decimal > max){
                max = decimal;
            }
        }

        System.out.print(max);
    }
}