import java.util.Scanner;
class Product {
    String name;
    int code;

    public Product() {
        this.name = "codetree";
        this.code = 50;
    }

    public Product(String name, int code){
        this.name = name;
        this.code = code;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        // Please write your code here.
        Product a = new Product();
        Product b = new Product(id2, code2);

        System.out.println("product " + a.code +" is " + a.name);
        System.out.println("product " + b.code +" is " + b.name);
        
    }
}