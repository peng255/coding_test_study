import java.util.*;

public class Main {
    
    public static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        

        // i번째 (x,y)를 건너뜀. 0번째와 n-1번째는 건너뛰지 x
        for (int i = 1; i < n-1; i++){
            int newDist = 0;
            int prevX = x[0];
            int prevY = y[0];
            for (int j = 1; j < n; j ++){
                if(j==i){
                    continue;
                }
                int currX = x[j];
                int currY = y[j];

                newDist += getDistance(prevX, prevY, currX, currY);
                // System.out.printf("prevX %d prevY %d currX %d currY %d newDist %d\n", prevX, prevY, currX, currY, newDist);
                prevX = currX;
                prevY = currY;
            }
            min = Math.min(min, newDist);
        }

        System.out.println(min);

    }
}