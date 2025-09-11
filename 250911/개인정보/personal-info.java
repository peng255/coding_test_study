import java.util.*;
class Student {
    String name;
    int height;
    double weight;

    public Student(String name, int height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        String[] names = new String[n];
        int[] heights = new int[n];
        double[] weights = new double[n];

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            heights[i] = sc.nextInt();
            weights[i] = sc.nextDouble();
            students[i] = new Student(names[i], heights[i], weights[i]);
        }

        Arrays.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student a, Student b){
                return a.name.compareTo(b.name);
            }
        });

        System.out.println("name");
        for(int i = 0; i < n; i ++){
            System.out.printf("%s %d %.1f\n", students[i].name, students[i].height, students[i].weight);
        }

        Arrays.sort(students, (a,b)-> b.height - a.height);

        System.out.println("\nheight");
        for(int i = 0; i < n; i ++){
            System.out.printf("%s %d %.1f\n", students[i].name, students[i].height, students[i].weight);
        }
    }
}