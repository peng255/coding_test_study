import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 동 서 남 북
        int[] dx = {1, -1, 0 , 0};
        int[] dy = {0, 0, -1, 1};
        int curX = 0;
        int curY = 0;

        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            
            int dirIdx = convert(direction);
            curX += (dx[dirIdx] * distance);
            curY += (dy[dirIdx] * distance);
            
        }

        System.out.println(curX + " " + curY);
    }

    public static int convert(char direction){
        int idx=0;
        if( direction == 'E' ){
            return 0;
        } else if (direction == 'W'){
            return 1;
        } else if (direction == 'S'){
            return 2;
        } else return 3;
    }
}