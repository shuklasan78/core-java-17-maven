package collection.list;
import basics.Person;
import data.CSVDataProcessor;
import data.Employee;
import data.GetData;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeStreamList {

    public static void main(String[] args) {
        practiceBasicStreamList();
       // practicePeron();
    }

    private static void practiceBasicStreamList() {

        List<Integer> list1 = Arrays.asList(1,2,4,6,9,44,29,17);
        //list1.stream().filter(p->p>10).sorted().forEach(p-> System.out.println(p));
        //list1.stream().filter(p->p>10).map(p->p%2).forEach(p-> System.out.println(p));
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
        //we dont have to create the list
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1
        //No need of loop
        IntStream.range(1, 4)
                .forEach(System.out::println);
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));




    }


    private static void practiceMillionRecords() {
        Set<Employee> empIdOddSet = new HashSet<>();
        List<Employee> empList = GetData.getListWithOneMRecords();
        for(Employee empId : empList) {
            if(empId.getEmpId()!=null)
            {
                if((empId.getEmpId())%2==0) {
                    empIdOddSet.add(empId);
                }
            }
        }
    }

}
