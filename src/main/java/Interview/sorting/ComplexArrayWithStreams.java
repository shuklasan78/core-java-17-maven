package Interview.sorting;

import data.Employee;
import data.GetEmployeeData;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
public class ComplexArrayWithStreams {

    public static void main(String[] args) {
        //comparePerformance();
        executeDuplicateFromArrayAndGetStreamFromArray();
    }
    private static void comparePerformance() {
        testQuickortingWithArray();
        getSortedArraysBasedOnIdUsingMergerSort();
        sortArrayUsingStreams();
        arrayStreamParallelSort();
    }

    private static void executeDuplicateFromArrayAndGetStreamFromArray() {
        getDuplicateFromArrays();
        getStreamsWithArrays();
    }

    private static void arrayStreamParallelSort() {
        Employee[] empArray = getEmployeeArray();
        long start = System.currentTimeMillis();
        Comparator<Employee> empComparator = Comparator.comparing(Employee::getEmpId);
        Arrays.parallelSort(empArray, empComparator);
        long finish = System.currentTimeMillis();
        log.info("ParallelSort Time :"+Long.valueOf(finish-start).toString());
    }

    private static void testQuickortingWithArray() {
        Employee[] empArray = getEmployeeArray();
        long start = System.currentTimeMillis();
        int n = empArray.length;
        Quick q1 = new Quick();
        q1.printArr(empArray, n);
        q1.quick(empArray, 0, n - 1);
        q1.printArr(empArray, n);
        long finish = System.currentTimeMillis();
        log.info("Quicksort Time :"+Long.valueOf(finish-start).toString());

    }

    private static void getSortedArraysBasedOnIdUsingMergerSort() {
        Employee[] empArray = getEmployeeArray();
        long start = System.currentTimeMillis();
        ImplementMergeSort.mergeSort(empArray,empArray.length-1);
        long finish = System.currentTimeMillis();
        log.info("MergeSort. :"+Long.valueOf(finish-start).toString());
        var counter =0;
        /*for(Employee emp : empArray) {
            if(counter<=10) {
                //log.info("EmpId={} :"+emp.getEmpId()+"    FirstName  :"+emp.getFirstname());
            }
            counter++;
        }*/

    }
    private static void sortArrayUsingStreams() {
        Employee[] empArray = getEmployeeArray();
        long start = System.currentTimeMillis();
        Arrays.sort(empArray, Comparator.comparing(Employee::getEmpId));
        long finish = System.currentTimeMillis();
        log.info("Stream Sort  :"+Long.valueOf(finish-start).toString());
        //Arrays.sort(employees, Comparator.comparing(Employee::getName).reversed());
       /* var counter =0;
        for(Employee emp : empArray) {
            if(counter<=10) {
                log.info("EmpId={} :"+emp.getEmpId()+"    FirstName  :"+emp.getFirstname());
            }
            counter++;
        }*/
    }
    private static Employee[] getEmployeeArray() {
        long start = System.currentTimeMillis();
        List<Employee> empList = GetEmployeeData.getEmployeeListWithOneMRecords();
        long finish = System.currentTimeMillis();
        //log.info("Load `time for EmpList :"+Long.valueOf(finish-start).toString());
        Employee[] emp = new Employee[empList.size()];
        start = System.currentTimeMillis();
        emp = empList.toArray(emp);
        finish = System.currentTimeMillis();
        //log.info("Time to convert List to Array :"+Long.valueOf(finish-start).toString());
        //log.info("Total Number of records :"+empList.size());
        return emp;
    }
    private static void getDuplicateFromArrays() {
        Map<Integer, Integer> nameAndCount = new HashMap<>();
        Map<Integer, List<Employee>> otherMap = new HashMap<>();
        List<Employee> listEmployee = new ArrayList<>();
        Employee[] arrEmp = getEmployeeArray();
        for(Employee emp : arrEmp) {
            Integer count = nameAndCount.get(emp.getEmpId());
            if (count == null) {
                nameAndCount.put(emp.getEmpId(), 1);
            } else {
                nameAndCount.put(emp.getEmpId(), ++count);
                listEmployee.add(emp);
                otherMap.put(emp.getEmpId(),listEmployee);
            }
        }
        System.out.println(otherMap.keySet());
        Map<Integer, List<Employee>> otherMap2 = new HashMap<>();
        for(Integer value : otherMap.keySet()) {
            if(value>=1) {
                otherMap2.put(value,otherMap2.get(value));
            }
        }
        log.info("duplicate={}"+otherMap2.size());

    }

    private static void getStreamsWithArrays() {
        Employee[] empArray = getEmployeeArray();
        Employee maxAge = Arrays.stream(empArray)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        log.info("Max Age :"+maxAge.getUserName());

    }


}
