package collection;

import data.Employee;
import data.GetData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummaryCollection {

    public static void main(String[] args) {
        //practiceArrayCollection();
        //practiceArraySorting();
        playWithList();
    }

    private static void practiceArrayCollection() {
        List<Employee> empList = GetData.getListWithOneMillionRecords();        // Get List
        Employee[] empArray = new Employee[empList.size()];
        empArray = empList.toArray(empArray);                                   // Convert List into Arrays
        Set<Employee> empSet = Set.of(empArray);                                // convert Arrays to Set

        Set<Employee> empSetMutable = new HashSet<>(Arrays.asList(empArray));   // converts Arrays to Set
        final Employee[] temp = empArray;
        // creating map using Arrays
        Map<Integer,Employee> map = IntStream.range(0, empArray.length).boxed()
                .collect(Collectors.toMap(i -> temp[i].getEmpId(), i -> temp[i],(oldValue, newValue) -> newValue));
    }

    private static void practiceArraySorting() {
        Comparator<Employee> sorter = (a,b)-> a.getEmpId().compareTo(b.getEmpId());
        Comparator<Employee> sorterName = (a,b) -> a.getFirstname().compareTo(b.getFirstname());
        Comparator<Employee> sorter1 = Comparator.comparingInt(Employee::getEmpId);

        List<Employee> empList = GetData.getListWithOneMillionRecords();        // Get List
        Employee[] empArray = new Employee[empList.size()];
        Arrays.sort(empArray,sorter);   // First way
        Arrays.sort(empArray,Comparator.comparing(Employee::getEmpId)); //Second Way

    }

    private static void playWithList() {
        //Convert Arrays to list
        List<Employee> empList = Arrays.asList(getEmployeeArray());
        //convert list to Set.
       Set<Employee> empSet = new HashSet<>(empList);
       //java 10 onwards
        Set<Employee> empSet10 = Set.copyOf(empList);
       //convert list to HashMap
        Map<Integer, List<Employee>> choiceMap =
                empList.stream().collect(Collectors.groupingBy(choice -> choice.getEmpId()));
        System.out.println("Map Size is :"+choiceMap.size());
        //convert list to map replace with new value
        Map<Integer, Employee> choiceMap1 =empList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity(),(n,o)->n));
        //cpnvert list to map when there are no duplicates
        Map<Integer, Employee> choiceMap2 =empList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
        //conver list to map using lambda expression
        Map<Integer, Employee> choiceMap3 =empList.stream().collect(Collectors.toMap(p->p.getEmpId(), p->p));
        //conver list to map using lambda expression when no duplicate in key
        Map<Integer, Employee> choiceMap4 =empList.stream().collect(Collectors.toMap(p->p.getEmpId(),  Function.identity(), (n,o)->n));
        //grouping map by Id
        Map<Integer, List<Employee>> groupedById = empList.stream().collect(Collectors.groupingBy(p->p.getEmpId()));

    }



    private static Employee[] getEmployeeArray() {
        List<Employee> empList = GetData.getListWithOneMillionRecords();        // Get List
        Employee[] empArray = new Employee[empList.size()];
        empArray = empList.toArray(empArray);
        return empArray;
    }

    private static Set<Employee> getEmployeSet() {
        Employee[] empArray = getEmployeeArray();
        Set<Employee> empSet = new HashSet<>(Arrays.asList(empArray));
        return empSet;
    }

    private static Map<Integer, Employee> getEmployeeMap() {
        final Employee[] empArr = getEmployeeArray();
        Map<Integer,Employee> employeMap = IntStream.range(0, empArr.length-1).boxed()
                .collect(Collectors.toMap(i -> empArr[i].getEmpId() , i-> empArr[i], (oldValue,newValue)->newValue));
        return employeMap;
    }
}
