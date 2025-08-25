import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        // Please write your code here.
        for (int i = 0; i < rowNum ; i ++){
            printLine(colNum);
        }
        
    }
    private static void printLine(int col) {
        for (int i = 0; i< col; i++){
            System.out.print("1");
        }
        System.out.println();
    }
}