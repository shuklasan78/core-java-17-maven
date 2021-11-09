package collection.set;
import data.Employee;
import data.GetEmployeeData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeSet {

    public static void main(String[] args) {
        //getSetEmpId();
        //getEmpIdSummary();
        //getOnlyDistinctDataSet();
        getUniquedElementInMapFromList();
    }

    private static Set<Integer> getSetEmpId() {
        List<Employee> empList = GetEmployeeData.getEmployeeListWithOneMRecords().stream().collect(Collectors.toList());

        System.out.println("Size of the List :"+empList.size());
        List<Integer> empIdList = new ArrayList<>();
        empList.forEach(p-> empIdList.add(p.getEmpId()));
        System.out.println("Emp Id Sets are :"+empIdList.size());
        Set<Integer> empSet = new HashSet<>();
        empIdList.forEach(p->empSet.add(p));
        //System.out.println("Number of Duplicate records are :"+empSet);
        return  empSet;
    }

    private static void getEmpIdSummary() {
        Set<Integer> setEmpId = getSetEmpId();
        Stream<Integer> valuesSorted  = setEmpId.stream().sorted();

        //System.out.println("The sorted values are :"+valuesSorted.toList());

        System.out.println("Maximum Element = "+Collections.max(setEmpId));
        System.out.println("Minimum Element = "+Collections.min(setEmpId));

        //int maxKey = Collections.max(map.keySet());
        //int maxValue Collections.max(map.values());
    }

    private static Set<Employee> getOnlyDistinctDataSet() {

        List<Employee> empList = GetEmployeeData.getEmployeeListWithfewRecords();
        System.out.println("empList :"+empList.size());
        //Set<Employee> empSet = empList.stream().collect(Collectors.toSet(Employee::getEmpId, c -> c, (c1, c2) -> c1));
        Set<Employee> empSet = empList.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getEmpId))));
        System.out.println(empSet.size());

        return empSet;
    }

    private static Set<Employee> getUniquedElementInMapFromList() {
        List<Employee> empList = GetEmployeeData.getEmployeeListWithfewRecords();
        List<Employee> uniqueEmployee = empList.stream()
                .distinct()               // it will remove duplicate object, It will check duplicate using equals method
                .collect(Collectors.toList());
        System.out.println("empList   :"+empList.size()+"   uniqueEmployee   :"+uniqueEmployee.size());

        empList.stream().filter(i -> Collections.frequency(empList, i) >1)
                .collect(Collectors.toSet()).forEach(System.out::println);

        return null;
    }



}
