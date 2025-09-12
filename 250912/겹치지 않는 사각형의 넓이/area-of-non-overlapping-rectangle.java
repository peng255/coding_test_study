import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int OFFSET = 1000;
        int[] x1 = new int[3];
        int[] x2 = new int[3];
        int[] y1 = new int[3];
        int[] y2 = new int[3];
        int[][] map = new int[2000][2000];

        for (int i = 0; i < 3; i ++){
            x1[i] = sc.nextInt() + OFFSET;
            y1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
            y2[i] = sc.nextInt() + OFFSET;

            // System.out.printf("x1 %d y1 %d x2 %d y2 %d\n", x1[i], y1[i], x2[i], y2[i]);
        }
        
        // 맨왼쪽 x1 구하기
        int minX1 = Math.min(Math.min(x1[0], x1[1]), x1[2]);
        int minY1 = Math.min(Math.min(y1[0], y1[1]), y1[2]);
        int maxX2 = Math.max(Math.max(x2[0], x2[1]), x2[2]);
        int maxY2 = Math.max(Math.max(y2[0], y2[1]), y2[2]);

        // System.out.printf("minX1 %d minY1 %d maxX2 %d maxY2 %d\n", minX1, minY1, maxX2, maxY2);

        // 영역 표시하는거니까 끝점인 최대 x2는 포함xx
        for (int i = minX1; i <maxX2; i ++){
            for (int j = minY1; j < maxY2; j ++){
                for (int k = 0; k < 3; k++){
                    if( x1[k]<=i && i<x2[k] && y1[k]<=j && j<y2[k]){
                        map[i][j] = k+1; // 기본배열값이 0이니까 표시할때는 1,2,3
                    }
                }
                
            }
        }

        int sum = 0;


        for (int i = minX1; i < maxX2; i ++){
            for (int j = minY1; j < maxY2; j ++){
                // System.out.print(map[i][j] + " ");

                if(map[i][j] == 1 || map[i][j]==2){
                    sum++;
                }
            }
            // System.out.println();
        }

        System.out.println(sum);
    }
}