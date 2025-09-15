import java.util.Scanner;
// 해설에 나온 이 방식이 더 좋은듯 !!! 참고하기
public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int n;
    public static int x1, x2;
    public static int maxX1;
    public static int minX2 = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        // 시작점 중 가장 뒤에 있는 좌표와 끝점 중 가장 앞에 있는 점의 좌표를 확인합니다.
        for(int i = 0; i < n; i++) {
            x1 = sc.nextInt();
            x2 = sc.nextInt();
            maxX1 = Math.max(maxX1, x1);
            minX2 = Math.min(minX2, x2);
        }
        
        // 만약 어느 한 선분이라도 시작점이 다른 선분의 끝점보다 뒤에 온다면
        // 선분이 전부 겹칠 수 없습니다.
        // 제일 큰 시작점 <= 제일 작은 끝점 
        if(minX2 >= maxX1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}


// import java.util.Scanner;
// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] start = new int[n];
//         int[] end= new int[n];
        
//         for(int i = 0; i < n; i ++){
//             start[i] = sc.nextInt();
//             end[i] = sc.nextInt();
//         }
        
//         for(int x = 1; x <= 100; x++){
//             boolean found = true;
//             for(int i = 0; i < n; i ++){
//                 if(start[i]>x || end[i]<x){
//                     found = false;
//                     break; // 다음 x로 건너뛰기
//                 }
//             }
//             if(found){
//                 System.out.print("Yes");
//                 return;
//             }
//         }
//         System.out.print("No");
//     }
// }