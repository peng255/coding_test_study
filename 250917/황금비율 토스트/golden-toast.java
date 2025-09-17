import java.util.*;

public class Main {

    public static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //식빵개수
        int m = sc.nextInt(); //명령문 개수
        String s = sc.next();
        // System.out.println(s);
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator(list.size());
        
        for (int i = 0; i < m; i++) {
            char command = sc.next().charAt(0);
            if(command == 'L'){
                if(iter.hasPrevious())
                    iter.previous();
                
            } else if(command == 'R'){
                if(iter.hasNext())
                    iter.next();

            } else if(command == 'D'){
                if(iter.hasNext()){
                    iter.next();
                    iter.remove(); // 윗줄에서 지났던 요소를 삭제
                }
            } else if(command == 'P'){
                char c = sc.next().charAt(0);
                iter.add(c);
                // System.out.printf("add 후의 next결과 %c\n", iter.next());
                // iter.previous(); // 최종에 없애기
            }
        }
        
        ListIterator<Character> print = list.listIterator();
        while(print.hasNext()){
            System.out.print(print.next());
        }
    }
}