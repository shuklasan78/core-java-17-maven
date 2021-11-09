package data;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class GetData {

    public static void main(String[] args){

        log.info("Size of the list getListWithfewRecords is :"+getListWithfewRecords().size());
        log.info("Size of the list getListWith50KRecords is :"+getListWithOneMRecords().size());

    }

    public static List<Employee> getListWithfewRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeFewRecords.toString());
        return originalList;
    }

    public static List<Employee> getListWithDuplicateRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeDuplicateRecords.toString());
        return originalList;
    }

    public static List<Employee> getListWithOneMRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeRecords1M.toString());
        return originalList;
    }

    public static List<Employee> getListWithTwoMRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeRecords2M.toString());
        return originalList;
    }

    public static List<Employee> getListWithFiveMillionRecords(){
        List<Employee> originalList = CSVDataProcessor.readEmployeesCSVFile(FilesEnum.EmployeeRecords5M.toString());
        return originalList;
    }

    public static List<SalesVO> getFiveMillionSalesRecord(){
        List<SalesVO> originalList = CSVDataProcessor.readSalesCSVFile(FilesEnum.SalesRecords5M.toString());
        return originalList;
    }

    public static Employee[] getEmployeeArray(){
        List<Employee> empList = GetData.getListWithDuplicateRecords();        // Get List
        Employee[] empArray = new Employee[empList.size()];
        empArray = empList.toArray(empArray);
        return empArray;
    }

    public static Set<Employee> getEmployeSet(){
        Employee[] empArray = getEmployeeArray();
        Set<Employee> empSet = new HashSet<>(Arrays.asList(empArray));
        return empSet;
    }

    public static Map<Integer, Employee> getEmployeeMap(){
        final Employee[] empArr = getEmployeeArray();
        Map<Integer,Employee> employeMap = IntStream.range(0, empArr.length-1).boxed()
                .collect(Collectors.toMap(i -> empArr[i].getEmpId() , i-> empArr[i], (oldValue, newValue)->newValue));
        return employeMap;
    }


}
