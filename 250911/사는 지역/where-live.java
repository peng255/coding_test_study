import java.util.*;

class Person implements Comparable<Person>{
    String name;
    String address;
    String region;

    public Person(String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }

    @Override
    public int compareTo(Person p){
        // this compareTo p 하면 오름차순
        // 거꾸로 p comparTo this 해야 내림차순
        return p.name.compareTo(this.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
            people[i] = new Person(names[i], addresses[i], regions[i]);
        }

        Arrays.sort(people);
        // sort 결과 확인
        // for (int i = 0; i < n; i ++){
        //     System.out.println(people[i].name);
        // }

        System.out.println("name " + people[0].name);
        System.out.println("addr " + people[0].address);
        System.out.println("city " + people[0].region);
    }
}