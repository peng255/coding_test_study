import java.util.Scanner;

class IntWrapper{
    int value;

    public IntWrapper(int value){
        this.value = value;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int max = a>b ? a : b;
        int min = a<b ? a : b;

        IntWrapper maxWrapper = new IntWrapper(max);
        IntWrapper minWrapper = new IntWrapper(min);
        modify(maxWrapper, minWrapper);

        System.out.print(minWrapper.value + " " + maxWrapper.value);
        

    }

    public static void modify(IntWrapper max, IntWrapper min){
        max.value += 25;
        min.value *= 2;
    }
}