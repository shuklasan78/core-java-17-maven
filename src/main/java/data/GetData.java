package data;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class GetData {

    public static void main(String[] args) {

        log.info("Size of the list getListWithfewRecords is :"+getListWithfewRecords().size());
        log.info("Size of the list getListWith50KRecords is :"+getListWith50KRecords().size());
        log.info("Size of the list getListWithOneMillionRecords is :"+getListWithOneMillionRecords().size());
        log.info("Size of the list getListWithTwoMillionRecords is :"+getListWithTwoMillionRecords().size());

    }

    public static List<Employee> getListWithfewRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("personfewrecords");
        return originalList;
    }

    public static List<Employee> getListWithDuplicateRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("personduplicaterecords");
        return originalList;
    }

    public static List<Employee> getListWith50KRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("person50krecords");
        return originalList;
    }

    public static List<Employee> getListWithOneMillionRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("persononemillionrecords");
        return originalList;
    }

    public static List<Employee> getListWithTwoMillionRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("persontwomillionrecords");
        return originalList;
    }

    public static List<SalesData> getFiveMillionSalesRecord() {
        List<SalesData> originalList = ProcessSalesRecords.readSalesDataFromCSV("salesfivemillionssalesrecords");
        return originalList;
    }

    public static List<Employee> getRecords(String records) {

        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV(records);
        return originalList;
    }

    public static Employee[] getEmployeeArray() {
        List<Employee> empList = GetData.getListWithDuplicateRecords();        // Get List
        Employee[] empArray = new Employee[empList.size()];
        empArray = empList.toArray(empArray);
        return empArray;
    }

    public static Set<Employee> getEmployeSet() {
        Employee[] empArray = getEmployeeArray();
        Set<Employee> empSet = new HashSet<>(Arrays.asList(empArray));
        return empSet;
    }

    public static Map<Integer, Employee> getEmployeeMap() {
        final Employee[] empArr = getEmployeeArray();
        Map<Integer,Employee> employeMap = IntStream.range(0, empArr.length-1).boxed()
                .collect(Collectors.toMap(i -> empArr[i].getEmpId() , i-> empArr[i], (oldValue, newValue)->newValue));
        return employeMap;
    }


}
