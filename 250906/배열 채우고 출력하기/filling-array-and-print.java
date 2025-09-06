import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        String[] arr = new String[10];

        Scanner sc = new Scanner(System.in);
        for(int i = 9; i >= 0; i --){
            arr[i] = sc.next();
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}