import java.util.Scanner;

public class Main {

    public static int count = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);

    }

    private static void print(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(count + " ");
                increment();
            }
            System.out.println();
        }
    }

    private static void increment(){
        if(count==9){
            count = 1;
            return;
        }
        count += 1;
    }
}