import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] seats = new char[n];

        int maxDistance = 0;
        int distCnt = 0;
        int maxEnd = -1;
        int cntOne=0;
        for(int i = 0; i < n; i++){
            seats[i] = s.charAt(i);

            distCnt++; // 거리 먼저 더한 후 max와 비교
            if(seats[i]=='1'){
                cntOne++;
                if(cntOne==1){// 처음만난 1은 다시 거리 초기화
                    distCnt=0;
                    continue;
                } else {
                    if(distCnt > maxDistance){
                        maxDistance = distCnt;
                        maxEnd = i;
                    }
                    distCnt = 0; // distCnt 초기화
                }
            }
        }
        // -> 중간에서 제일 먼 거리와 그 끝점 구함

        // 맨 앞에 앉을 수 있다면
        int fstOne = -1;
        if(seats[0] == '0'){
            for(int i = 0; i < n; i ++){
                if(seats[i]=='1'){
                    fstOne = i; // 맨앞에 앉으면 fstOne만큼 거리두기 가능!
                    break; // 맨 처음 만나는 1만 확인하고 그만 찾음
                }
            }
        }

        // 맨 끝에 앉을 수 있다면
        int lastOne = -1;
        if(seats[n-1] == '0'){
            for(int i = 0; i < n; i ++){
                if(seats[i]=='1')
                    lastOne = i; // n-lastOne-1 (예제2에서 14-8-1) 만큼 거리두기 가능
            }
        }

        // System.out.printf("중간거리 %d fstOne %d 끝거리 %d\n", maxDistance, fstOne, n-lastOne-1);
        int checkMax;
        if(lastOne != -1){
            checkMax = Math.max( Math.max(maxDistance/2, fstOne), (n-lastOne-1));
        } else {
            checkMax = Math.max(maxDistance/2, fstOne);
        }
        
        if(checkMax == maxDistance/2){ // 1과 1사이에 앉아야 한다면
            seats[ (maxEnd + (maxEnd-maxDistance))/2 ] = '1'; // 가운데에 앉음. maxEnd가 5처럼 홀수여도 2에 앉나 3에 앉나 상관x
        } else if(checkMax == fstOne){
            seats[0] = '1';
        } else {
            seats[n-1] = '1';
        }

        // System.out.println(Arrays.toString(seats));
        int minDistance = n;
        int minDistCnt = 0;
        cntOne = 0; // 1이 처음 나온 순간부터 세야함..맨왼쪽에 000이면 그 거리는 필요x
        for(int i = 0; i < n; i ++){
            minDistCnt ++;
            if(seats[i]=='1'){
                cntOne++;
            }
            if(seats[i]=='1' && cntOne==1) 
                minDistCnt=0; //첫 1 초기화

            // 첫 자리는 거리 세는거에서 제외해야 최소거리 잘 계산됨!
            if(seats[i]=='1' && cntOne>=2){ //지금 두번째 등장한 1일때
                // System.out.printf("minDistcnt %d minDistance %d\n", minDistCnt, minDistance);
                if(minDistCnt < minDistance){
                    minDistance = minDistCnt;
                }
                minDistCnt = 0;
            }
        }

        System.out.print(minDistance);
        
    }
}