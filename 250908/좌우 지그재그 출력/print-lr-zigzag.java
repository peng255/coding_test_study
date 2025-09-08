import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        // i =0 -> 1,2,3,4 
        // i =2 -> 9,10,11,12 = n*i + 1 + j

        // i =1 -> 8,7,6,5 
        // i =3 -> 16,15,14,13 = n*(i+1) - j

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i ++){
            for (int j =0; j < n; j ++){
                if ( i%2 == 0){
                    System.out.print(n * i + 1 + j + " ");
                } else {
                    System.out.print(n * (i+1) -j + " ");
                }
            }
            System.out.println();
        }
    }
}