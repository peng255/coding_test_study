import java.util.Scanner;
public class Main {

    public static int[] deleteResult(int s, int e){
        for(int i = s-1; i<= e-1; i++){
            blocks[i] = 0;
        }

        int[] result = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i ++){
            if(blocks[i] == 0)
                continue;
            result[idx++] = blocks[i];
        }

        return result;
    }

    public static int[] blocks;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }

        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        
        int[] temp = deleteResult(s1, e1);
        for(int i = 0; i < n; i ++){
            blocks[i] = temp[i];
        }
        temp = deleteResult(s2, e2);
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            blocks[i] = temp[i];
            if(blocks[i] != 0)
                cnt ++; // 남은 블록 수
        }

        System.out.println(cnt);
        for(int i = 0; i < cnt; i++){
            System.out.println(blocks[i]);
        }



    }
}