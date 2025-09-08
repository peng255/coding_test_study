import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 처음에 N Q
        // 그 아래로 N개의 원소 값들 한줄 
        // 그 아래로 명령어 Q줄 주어짐

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        // N개의 원소 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // q개의 질의 받기
        // Q의 종류
        // 1 a : a번째 원소 출력
        // 2 b : N개의 원소중에 b를 찾아서 몇번째인지 출력
        //     여러개면 min idx, 없으면 0
        // 3 s e : s번째 원소 ~ e번째 원소 값들을 " "로 구분해서 출력
        int typenum;
        for (int i = 0; i < q; i++){
            typenum = sc.nextInt();

            if (typenum == 1){
                int a = sc.nextInt();
                System.out.println(arr[a-1]);
            }
            else if (typenum == 2){
                int b = sc.nextInt();
                int idx = 0;
                for (int j = 0; j < n; j++){
                    // b과 같은 값 찾으면 idx 저장하고 탐색중단
                    if (arr[j] == b){
                        idx = j+1;
                        break;
                    }
                }
                System.out.println(idx);
            }
            else {
                int s = sc.nextInt();
                int e = sc.nextInt();
                for (int j =s-1; j <= e-1; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println(); /////// 줄바꿈 까먹어서 틀렸다..
            }
        }

    }
}