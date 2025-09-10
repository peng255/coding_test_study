import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // Please write your code here.

        Arrays.sort(words);

        int idxcnt = 1;
        int len = t.length();
        for (int i = 0; i < n; i ++){
            if ( words[i].length() >= len &&
                (words[i].substring(0,len)).equals(t) ){
                if (idxcnt == k){
                    System.out.print(words[i]);
                    return;
                } else {
                    idxcnt ++;
                }
            }
        }
    }
}