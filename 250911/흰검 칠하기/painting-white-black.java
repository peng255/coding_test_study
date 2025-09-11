import java.util.*;

class Block{
    char color;
    int black;
    int white;

    public Block() {
        this.color = 'X';
        this.black = 0;
        this.white = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cur = 0;
        int[] start = new int[n];
        int[] end = new int[n];
        char[] dir = new char[n];

        int minusMax = 0;
        int plusMax = 0;
        
        // 시작[] 끝[] 배열에 기록
        // 제일 왼쪽, 오른쪽 지점 기록 -> offset과 좌표배열설정에 활용
        for (int i = 0; i < n; i++) {
            // 0에서 출발한다고 가정하고

            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            start[i] = cur;
            dir[i] = d;

            if( d=='R' ){
                end[i] = cur + (x-1);

            }
            else {
                end[i] = cur - (x-1);
            }
            
            if ( end[i] > plusMax ){
                plusMax = end[i];
            }
            if ( end[i] < minusMax ){
                minusMax = end[i];
            }

            // 현재위치 업데이트 !! 
            cur = end[i];
            // System.out.printf("start %d end %d\n", start[i], end[i]);
        }

        int offset = (-1) * minusMax;
        int coordnateSize = plusMax + offset + 1;
        // System.out.printf("offset %d size %d\n", offset, coordnateSize);
        // offset을 반영해서 시작[] 끝[] 배열 조정하기
        for (int i = 0; i < n; i ++){
            start[i] += offset;
            end[i] += offset;
        }

        // 초기화된 블럭들로 된 배열 만들기
        Block[] blocks = new Block[coordnateSize];
        for (int i = 0; i < coordnateSize; i ++){
            blocks[i] = new Block();
        }

        for (int i = 0; i < n; i ++){

            if( dir[i] == 'R' ){
                for (int j = start[i]; j <= end[i]; j++){
                    // 지금 위치의 블럭이 gray라면 건너뛰기
                    if( blocks[j].color == 'G' ){
                        continue;
                    }
                    blocks[j].color = 'B';
                    blocks[j].black ++;

                    if ((blocks[j].black >= 2) && (blocks[j].white>=2)){
                        blocks[j].color = 'G';
                    }
                    
                }
            }
            // 'L'이라면 W로 색칠
            else {
                for (int j = start[i]; j >= end[i]; j--){
                    if( blocks[j].color == 'G' ){
                        continue;
                    }
                    blocks[j].color = 'W';
                    blocks[j].white ++;

                    if ((blocks[j].black >= 2) && (blocks[j].white>=2)){
                        blocks[j].color = 'G';
                    }
                }
            }
            
        }
        
        int white, black, gray;
        white = black = gray = 0;
        for (int i = 0; i < coordnateSize; i ++){
            // System.out.print(blocks[i].color + " ");
            if (blocks[i].color == 'W')
                white ++;
            else if (blocks[i].color == 'B')
                black ++;
            else if (blocks[i].color == 'G')
                gray ++;
        }
        System.out.printf("%d %d %d\n", white, black, gray);
    }
}