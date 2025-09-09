import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String a  = sc.nextLine();
        String b = sc.nextLine();

        String[] arr1 = a.split(" ");
        String[] arr2 = b.split(" ");

        for (String s:arr1) {
            System.out.print(s);
        }
        for (String s:arr2) {
            System.out.print(s);
        }
    }
}