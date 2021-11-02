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
        //playWithList();
        //playWithListComparator();
        //mapPractice();
        mapIterate();
    }

    private static void practiceArrayCollection() {
        List<Employee> empList = GetData.getListWithfewRecords();        // Get List
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

    private static void playWithListComparator() {
        Comparator<Employee> empSorterEmpId = (a,b) -> a.getEmpId().compareTo(b.getEmpId());
        Comparator<Employee> empSorterName = (a,b) -> a.getFirstname().compareTo(b.getFirstname());
        Comparator<Employee> empSorterOtherWayEmpId = Comparator.comparing(Employee::getEmpId);
        Comparator<Employee> empSorterOtherWayFirstNam = Comparator.comparing(Employee::getFirstname);

        List<Employee> empList = GetData.getListWithfewRecords();
        //simple sorting
        empList = empList.stream().sorted(empSorterEmpId).toList();
        empList.forEach(p-> System.out.println("EmpId "+p.getEmpId()));
        //different sorting
        empList = empList.stream().sorted(empSorterOtherWayFirstNam).toList();
        for (Employee employee : empList) {
            System.out.println("The Names are "+employee.getEmpId()+"="+employee.getFirstname());
        }

    }

    private static Employee[] getEmployeeArray() {
        List<Employee> empList = GetData.getListWithDuplicateRecords();        // Get List
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

    private static void mapPractice() {

        Map<Integer,Employee> mapEmployee = getEmployeeMap();
        //convert map to Arrays
        Employee[] empArr = mapEmployee.values().toArray(new Employee[0]);
        for(Employee emp: empArr) {
            if(emp.getAgeInYrs()>0 ){
                System.out.println("Name is :"+emp.getUserName());
            }
        }
        //convert map to set
        Set<Employee> setEmployee = mapEmployee.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
        //Convert Map Keys as Set
        Set<Integer> empSetId = mapEmployee.keySet();
        //Extract specific values from Map into Set
        Set<Double> ageSet =  new HashSet<>();
        for (Employee employee : mapEmployee.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet())) {
           ageSet.add(employee.getAgeInYrs());
        }
        System.out.println("AgesSet is :"+ageSet);


        //convert map to List
        List<Employee> empList  = mapEmployee.values().stream().toList();
        System.out.println("List Size from Map is : :"+empList.size());



        }

    private static void mapIterate() {
        Map<Integer,Employee> mapEmployee = getEmployeeMap();
        //Using for each
        mapEmployee.forEach((id, name) -> {
            System.out.println("Key : " + id + " value : " + name.getUserName());
        });
        // Using entry set using forEach
        mapEmployee.entrySet().stream().forEach(e ->
                System.out.println("Key : " + e.getKey() + " value : " + e.getValue().getUserName())
        );
        // using Entry Set
        for (Map.Entry<Integer, Employee> entry : mapEmployee.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue().getFirstname());
        }
        // Using for keyset
        for (Integer key : mapEmployee.keySet()) {
            System.out.println("Key : " + key + " value : " + mapEmployee.get(key).getUserName());
        }
        //This way is more suitable for when you need to remove some data while iterating.

        Iterator<Map.Entry<Integer, Employee>> iterator = mapEmployee.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }

}
