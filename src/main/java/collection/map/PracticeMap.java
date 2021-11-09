package collection.map;

import data.Employee;
import data.GetEmployeeData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeMap {

    public static void main(String[] args) {
        //getMapEmployeeWithDuplicateKeyException();
        getComvertedMapFromListWithDuplicateRecords();
    }

    private static Map<Integer, Employee> getMapEmployeeWithDuplicateKeyException() {
        List<Employee> empList = GetEmployeeData.getEmployeeListWithOneMRecords();
        System.out.println("The size of the list is :"+empList.size());
        //Java 8 using Lambdas
        Map<Integer, Employee> empMap =  empList.stream().collect(Collectors.toMap(Employee -> Employee.getEmpId(), Employee->Employee));
        System.out.println("The size of the map is :"+empMap.size());
        //Using Java 8 method reference
        Map<Integer, Employee> result = empList.stream() .collect(Collectors.toMap(Employee::getEmpId, Employee-> Employee));
        Map<Integer, Employee> result2 = empList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity()));

        return result2;
    }

    private static Map<Integer, Employee> getComvertedMapFromListWithDuplicateRecords() {
        List<Employee> empList = GetEmployeeData.getEmployeeListWithfewRecords();
        //TODO
        //Map<Integer, Employee> myMap =  empList.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1));
        Map<Integer, Employee> result1 = empList.stream()
                .collect(Collectors.toMap(Employee::getEmpId, Employee::new, (oldValue, newValue) -> newValue));
        System.out.println("ListSize :"+empList.size());
        System.out.println("MapSize :"+result1.size());
        Map<Integer, Employee> result2 = empList.stream()
                .collect(Collectors.toMap(Employee::getEmpId, e->e , (oldValue, newValue) -> newValue,LinkedHashMap:: new));
        System.out.println(result2);
        return result1;
    }
}
