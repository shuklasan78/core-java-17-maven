package basics;

import data.Employee;
import data.GetEmployeeData;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamsBasic {

    public static void main(String[] args) throws IOException {
        StreamsBasic o1 = new StreamsBasic();
        //o1.convertListToSet();
        //listToMap();
        //calculateMaxMinSumFromList();
        //sortBasdOnAgeOnList();
        //getMapToList();
        QueryValuesFromList();
    }


    private void  convertListToSet() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        System.out.println("ORIGINAL LIST SIZE :"+employeeList.size());
        Set<Integer> salarySet = new HashSet<>();
        employeeList.stream().forEach(p->salarySet.add(p.getSalary()));
        //sorting `set into natural order
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

    private static Map<Integer, Employee> listToMap() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();

        Map<Integer, Employee> listEmployee  = employeeList.stream()
                .collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
        System.out.println("The map values are :"+listEmployee.size());
        return listEmployee;
    }

    private static void calculateMaxMinSumFromList() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        IntSummaryStatistics stats = employeeList.stream().mapToInt((x)->x.getSalary()).summaryStatistics();
        System.out.println("The total value of salary is :"+stats.getSum());
        System.out.println("Maximum salary :"+stats.getMax() +"   Minimum Salary :"+stats.getMin());

    }

    private static void sortBasdOnAgeOnList() throws IOException {

        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords().stream().sorted(Comparator.comparingDouble(Employee::getAgeInYrs)).collect(Collectors.toList());
        employeeList.forEach(p-> System.out.println("Name  :"+p.getFirstname()+"              AgeinYears     :"+p.getAgeInYrs()));

        List<Employee> employeeList2 = GetEmployeeData.getEmployeeListWithfewRecords();
        List<Employee> sortedList = employeeList2.stream()
                .sorted((o1, o2) -> {
                    if(o1.getAgeInYrs() == o2.getAgeInYrs())
                        return o1.getFirstname().compareTo(o2.getFirstname());
                    else if(o1.getAgeInYrs() > o2.getAgeInYrs())
                        return 1;
                    else return -1;
                })
                .collect(Collectors.toList());
        //sortedList.forEach(p-> System.out.println("Name  :"+p.getFirstname()+"              AgeinYears     :"+p.getAgeInYrs()));

    }

    private static void getMapToList() throws IOException {
        Map<Integer, Employee> employeeMap = listToMap();
        List<Integer> arrlist = employeeMap.keySet()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));
        arrlist = employeeMap.keySet()
                .stream().sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        arrlist.forEach(System.out::println);

        List<Employee> listArrayEmp = employeeMap.values()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("ListArraEmp :"+listArrayEmp);

    }

    private static void QueryValuesFromList() throws IOException {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        Map<String, Long> noOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAgeInYrs)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);

        Optional<Employee> highestPaidEmployeeWrapper=
                employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
        System.out.println("EmpID   :"+highestPaidEmployee.getEmpId()+"   Name  :"+highestPaidEmployee.getFirstname()+"    Salary  :"+highestPaidEmployee.getSalary() );
        employeeList.stream()
                .filter(e -> e.getYearOfJoining() <= 1980)
                .map(Employee::getFirstname)
                .forEach(System.out::println);

        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
                employeeList.stream()
                        .filter(e -> e.getGender().equalsIgnoreCase("M"))
                        .min(Comparator.comparingDouble(Employee::getAgeInYrs));
      //important
        Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

        System.out.println(youngestMaleEmployeeInProductDevelopment.getSalary());

        Optional<Employee> seniorMostEmployeeWrapper=
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();

        System.out.println("Senior Most Employee Details :"+seniorMostEmployee.getFirstname());


        // Stream operation to group students by age
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

}
