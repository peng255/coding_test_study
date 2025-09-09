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

        IntWrapper aWrapper = new IntWrapper(a);
        IntWrapper bWrapper = new IntWrapper(b);
        modify(aWrapper, bWrapper);

        System.out.print(aWrapper.value + " " + bWrapper.value);
        

    }

    public static void modify(IntWrapper a, IntWrapper b){
        IntWrapper max = a.value > b.value ? a : b;
        IntWrapper min = a.value < b.value ? a : b;
        max.value += 25;
        min.value *= 2;
    }
}