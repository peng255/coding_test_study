import java.util.*;

class Student{
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            students[i] = new Student(name, height, weight);
        }

        Arrays.sort(students, (a,b)->
            // 키 오름차순
            // 키 같으면 몸무게 내림차순
            a.height != b.height ? a.height - b.height : b.weight - a.weight
        );

        for (int i = 0; i < n; i ++){
            System.out.println(students[i].name + " " + students[i].height + " " + students[i].weight);
        }
    }
}