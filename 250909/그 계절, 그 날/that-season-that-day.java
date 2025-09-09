import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        // y해에 m월 d일이 존재하나? 없으면 -1
        if ( !exists(y, m, d) ){
            System.out.print(-1);
            return;
        }

        // 존재한다면 어떤 계절?
        System.out.print( checkSeason(m) );

    }

    public static boolean exists(int y, int m, int d){
        int[] month1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 윤년이라 month2 이용
        if(isYoon(y)){
            if( month2[m-1] >= d ){
                return true;
            } else {
                return false;
            }
        } else {
            if( month1[m-1] >= d ){
                return true;
            } else {
                return false;
            }
        }

    }

    public static boolean isYoon(int y){
        // 4의 배수이면서 400배의 배수가 아니면 윤년이 아님
        if (y%100==0 && y%400!=0){
            return false;
        }
        // 나머지 케이스 중에 4의 배수면 윤년임
        else if (y%4==0){
            return true;
        } 
        // 그냥 4의 배수도 아니면 윤년 아님
        else {
            return false;
        }
    }

    public static String checkSeason(int m){
        if (m==3 || m==4 || m==5){
            return "Spring";
        } else if( m==6 || m==7 || m==8 ){
            return "Summer";
        } else if ( m==9 || m==10 || m==11){
            return "Fall";
        } else {
            return "Winter";
        }
    }
}