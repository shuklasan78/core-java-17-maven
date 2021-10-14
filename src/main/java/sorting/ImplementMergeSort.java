package sorting;

import data.Employee;
import data.GetData;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ImplementMergeSort {


    public static void main(String[] args) {

    }

    private static void sortingArrayComparison() {
        testQuickortingWithArray();
        getSortedArraysBasedOnIdUsingMergerSort();
        sortArrayUsingStreams();
    }
    private static void testQuickortingWithArray() {
        long start = System.currentTimeMillis();

        Employee[] empArray = getEmployeeArray();
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
        mergeSort(empArray,empArray.length-1);
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
    private static void executeOtherMethod() {

        getDuplicateFromArrays();
        getStreamsWithArrays();
    }

    private static Employee[] getEmployeeArray() {
        long start = System.currentTimeMillis();
        List<Employee> empList = GetData.getListWithTwoMillionRecords();
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




    private static void getSortingBasedOnStreams() {
        long start = System.currentTimeMillis();
        List<Employee> empList = GetData.getListWithTwoMillionRecords();
        long finish = System.currentTimeMillis();
        log.info("Load `time for EmpList :"+Long.valueOf(finish-start).toString());

        List<Employee> sortedList = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getEmpId))
                .collect(Collectors.toList());

//        var counter =0;
//        for(Employee emp : sortedList) {
//            if(counter<=50) {
//                log.info("EmpId={} :"+emp.getEmpId()+"    FirstName  :"+emp.getFirstname());
//            }
//            counter++;
//        }
    }

    private static void getStreamsWithArrays() {
        Employee[] empArray = getEmployeeArray();
        Employee maxAge = Arrays.stream(empArray)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        log.info("Max Age :"+maxAge.getUserName());

    }



    public static void merge(Employee[] a, Employee[] l, Employee[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getEmpId() <= r[j].getEmpId()) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

    }
    public static void mergeSort(Employee[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Employee[] l = new Employee[mid];
        Employee[] r = new Employee[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
}
