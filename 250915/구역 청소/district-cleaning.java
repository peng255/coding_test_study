import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        int result = 0;
        // 안겹친다면 (b-a) + (d-c)
        if(b<c || d<a){
            result = (b-a) + (d-c);
        } else{
            result = Math.max(b,d) - Math.min(a,c);
        }

        System.out.print(result);
    }
}