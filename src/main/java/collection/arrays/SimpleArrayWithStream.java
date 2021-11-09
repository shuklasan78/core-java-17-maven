package collection.arrays;

import data.Employee;
import data.GetEmployeeData;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleArrayWithStream {

    public static void main(String[] args) {
        arraysAsStream();
    }

    /**
     *
     */
    private static void arraysAsStream() {
        String[] array = {"a", "b", "c", "d", "e"};
        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));

        Integer[] arrayInt = {1, 2, 3, 4, 5};
        Stream<Integer> streamInt = Arrays.stream(arrayInt);
        streamInt.forEach(p->{
            if(p>2) {
                System.out.println("The values are :"+p);
            }
        });
    }

    private static Employee[] listConvertToArrays() throws IOException {
        Comparator<Employee> empIdSorter = (a, b) -> a.getEmpId().compareTo(b.getEmpId());
        List<Employee> lstEmp = GetEmployeeData.getEmployeeListWithfewRecords().stream().sorted(empIdSorter).collect(Collectors.toList());
        for(Employee emp : lstEmp) {
            //System.out.println("Sorting List Differently :"+emp.getEmpId());
        }
        Employee[] empArray = new Employee[lstEmp.size()];
        empArray = lstEmp.toArray(empArray);
        return empArray;
    }

    private static Set<Employee> arrayConvertedToSet() throws IOException {
        Employee[] empArray = listConvertToArrays();
        Set<Employee> targetSet = new HashSet<Employee>(Arrays.asList(empArray));
        return targetSet;
    }

    private static Map<Integer, Employee> arraysConvertedToMap() throws IOException {
        List<Employee> lstEmp = GetEmployeeData.getEmployeeListWithfewRecords().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
        final Employee[] empArrayValues = listConvertToArrays();
        Integer[] keys = lstEmp.stream().map(Employee::getEmpId).toArray(Integer[]::new);
        System.out.println("empArrayValues   :"+empArrayValues.length+"    keys   :"+keys.length);
        if(keys.length != empArrayValues.length) {
            throw new IllegalArgumentException("Keys and Values need to have the same length.");
        }
        //cannot work becasue of duplicate keys
        Map<Integer,Employee> map = IntStream.range(0, keys.length).boxed()
                .collect(Collectors.toMap(i -> empArrayValues[i].getEmpId(), i -> empArrayValues[i],(oldValue, newValue) -> newValue));

        System.out.println("The converted map from Arrays length is :"+map.size());
        //.collect(Collectors.toMap(Employee::getEmpId, Function.identity(), (oldValue, newValue) -> newValue));

        return map;
        //int[] ages = persons.stream().mapToInt(Person::getAge).distinct().toArray();
    }

    private static void sortArraysDifferently() throws IOException {

        Comparator<Employee> empIdSorter = (a, b) -> a.getEmpId().compareTo(b.getEmpId());
        List<Employee> lstEmp = GetEmployeeData.getEmployeeListWithfewRecords().stream().sorted(empIdSorter).collect(Collectors.toList());
        Employee[] empArray = new Employee[lstEmp.size()];
        empArray = lstEmp.toArray(empArray);
        Arrays.sort(empArray, Comparator.comparing(Employee::getEmpId));  // two ways to comparing
        for (Employee emp : empArray) {
            System.out.println("Arrays ID  :" + emp.getEmpId());
        }
        Comparator<Employee> nameSorter = (a, b) -> a.getUserName().compareToIgnoreCase(b.getUserName());
        Arrays.sort(empArray, nameSorter);
        for (Employee emp : empArray) {
            System.out.println("Arrays username  :" + emp.getUserName());
        }
    }
}
