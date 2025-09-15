import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end= new int[n];
        
        for(int i = 0; i < n; i ++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        
        for(int x = 1; x <= 100; x++){
            boolean found = true;
            for(int i = 0; i < n; i ++){
                if(start[i]>x || end[i]<x){
                    found = false;
                    break; // 다음 x로 건너뛰기
                }
            }
            if(found){
                System.out.print("Yes");
                return;
            }
        }
        System.out.print("No");
    }
}