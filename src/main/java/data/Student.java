package data;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {

        // Create an list of student of objects
        ArrayList stdList = new ArrayList();
        stdList.add(new Student("Peter", 22));
        stdList.add(new Student("Sara", 23));
        stdList.add(new Student("Danial", 21));
        stdList.add(new Student("Siemen", 22));

        Collector<Student, StringJoiner, String> stdNameCollector =
                Collector.of(
                        () -> new StringJoiner(", "),          	// supplier
                        (i, s) -> i.add(s.name.toUpperCase()),  // accumulator
                        (x, y) -> x.merge(y),               	// combiner
                        StringJoiner::toString);                // finisher

      String names = (String) stdList.stream().collect(stdNameCollector);

        System.out.println(names);

    }
}