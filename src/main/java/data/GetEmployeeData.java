package data;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class GetEmployeeData {

    public static void main(String[] args){

        log.info("Size of the list getListWith50KRecords is :"+ getEmployeeList(FilesEnum.EmployeeRecords1M.toString()).size());

    }

    public static List<Employee> getEmployeeListWithfewRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeFewRecords.toString());
        return originalList;
    }

    public static List<Employee> getEmployeeListWithDuplicateRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeDuplicateRecords.toString());
        return originalList;
    }

    public static List<Employee> getEmployeeListWithOneMRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeRecords1M.toString());
        return originalList;
    }

    public static List<Employee> getEmployeeListWithTwoMRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeRecords2M.toString());
        return originalList;
    }

    public static List<Employee> getEmployeeList(String records){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(records);
        return originalList;
    }

    private static List<Employee> getSalesVOList(String records) {
        List<Employee> empList = null;
        if(records.equals(FilesEnum.EmployeeFewRecords.toString())) {
            empList = getEmployeeListWithfewRecords();
        } else if(records.equals(FilesEnum.EmployeeDuplicateRecords.toString())) {
            empList = getEmployeeListWithDuplicateRecords();
        } else if (records.equals(FilesEnum.EmployeeRecords1M.toString())) {
            empList = getEmployeeListWithOneMRecords();
        } else if (records.equals(FilesEnum.EmployeeRecords2M.toString())) {
            empList = getEmployeeListWithTwoMRecords();
        }
        return empList;
    }
    public static Employee[] getEmployeeArray(String records){
        List<Employee> empList = getSalesVOList(records);        // Get List
        Employee[] empArray = new Employee[empList.size()];
        empArray = empList.toArray(empArray);
        return empArray;
    }

    public static Set<Employee> getEmployeSet(String records){
        List<Employee> empList = getSalesVOList(records);        // Get List
        Employee[] empArray = getEmployeeArray(records);
        Set<Employee> empSet = new HashSet<>(Arrays.asList(empArray));
        return empSet;
    }

    public static Map<Integer, Employee> getEmployeeMap(String records){
        List<Employee> empList = getSalesVOList(records);        // Get List
        final Employee[] empArr = getEmployeeArray(records);
        Map<Integer,Employee> employeMap = IntStream.range(0, empArr.length-1).boxed()
                .collect(Collectors.toMap(i -> empArr[i].getEmpId() , i-> empArr[i], (oldValue, newValue)->newValue));
        return employeMap;
    }


}
