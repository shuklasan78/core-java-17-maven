package data;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class GetEmployeeData {

    public static void main(String[] args){

        log.info("Size of the list getListWithfewRecords is :"+ getEmployeeListWithfewRecords().size());
        log.info("Size of the list getListWith50KRecords is :"+ getEmployeeListWithOneMRecords().size());

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

    private static List<Employee> getSalesVOList(String records) {
        List<Employee> empList = null;
        if(records.equals("few")) {
            empList = getEmployeeListWithfewRecords();
        } else if(records.equals("duplicate")) {
            empList = getEmployeeListWithDuplicateRecords();
        } else if (records.equals("1M")) {
            empList = getEmployeeListWithOneMRecords();
        } else if (records.equals("2M")) {
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
