package collection.list;

import data.Employee;
import data.GetEmployeeData;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class ListBasicStream {

    public static void main(String[] args) throws IOException {
        practiceBasicStreamList();
        // practicePeron();
        calculateMaxMinSumFromList();
        convertListToSet();
        getBasicStreams();
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
    private static void calculateMaxMinSumFromList() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        IntSummaryStatistics stats = employeeList.stream().mapToInt((x)->x.getSalary()).summaryStatistics();
        System.out.println("The total value of salary is :"+stats.getSum());
        System.out.println("Maximum salary :"+stats.getMax() +"   Minimum Salary :"+stats.getMin());

    }

    private static void  convertListToSet() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        System.out.println("ORIGINAL LIST SIZE :"+employeeList.size());
        Set<Integer> salarySet = new HashSet<>();
        employeeList.stream().forEach(p->salarySet.add(p.getSalary()));
        //Interview.sorting `set into natural order
        salarySet.stream().sorted(Comparator.naturalOrder());
        salarySet.stream().sorted(Comparator.reverseOrder());

        List<Employee> noDuplicateList = employeeList.stream()
                .collect(groupingBy(Employee::getAgeInYrs,
                        Collectors.toList()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
        noDuplicateList.forEach(p-> System.out.println("EmpID   :"+p.getEmpId()+"  Salary :"+p.getSalary()+"  Name  :"+p.getUserName()+"  AgeInYears :"+p.getAgeInYrs()));
        System.out.println("noDuplicateList :"+noDuplicateList);
    }

    private static void getBasicStreams() {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream()
                .filter(x -> x.isEmpty())
                .count();
        System.out.println("Number of empty elements in List :"+count);

        long num = strList.stream()
                .filter(x -> x.length()> 3)
                .count();
        System.out.println("Number of  elements in List :"+num);

        List<String> filtered = strList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
        System.out.println("No empty string in list :"+filtered);

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println("List as String :"+G7Countries);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream()
                .map( i -> i*i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Sqaure of number :"+distinct);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Total Sum :"+stats.getSum()+" Average :"+stats.getAverage());

    }

    private static void practiceMillionRecords() {
        Set<Employee> empIdOddSet = new HashSet<>();
        List<Employee> empList = GetEmployeeData.getEmployeeListWithOneMRecords();
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
