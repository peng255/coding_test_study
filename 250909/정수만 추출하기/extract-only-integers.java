import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < s1.length(); i ++){
            // 숫자 아스키 코드가 아닌 char를 만나면 기록하고 break
            if (s1.charAt(i) < '0' || s1.charAt(i) > '9'){
                idx1 = i;
                break;
            }
        }

        for (int i = 0; i < s2.length(); i ++){
            if (s2.charAt(i) < '0' || s2.charAt(i) > '9'){
                idx2 = i;
                break;
            }
        }

        int num1 = Integer.parseInt(s1.substring(0,idx1));
        int num2 = Integer.parseInt(s2.substring(0,idx2));

        System.out.print(num1 + num2);
        
    }
}