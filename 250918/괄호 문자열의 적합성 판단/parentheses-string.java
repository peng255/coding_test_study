import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < str.length(); i ++){
            if(str.charAt(i) == '('){   
                stack.push('(');
            } 
            else if (str.charAt(i)==')'){
                if(stack.empty()){
                    System.out.print("No");
                    return;
                }
                // 비어있지 않다면 (를 꺼냄
                stack.pop();
            }
        }
        // 문자열 다 봤는데 (가 스택에 남아있으면 올바른 문자열x
        if(!stack.empty()){
            System.out.print("No");
            return;
        }

        System.out.print("Yes");
    }
}