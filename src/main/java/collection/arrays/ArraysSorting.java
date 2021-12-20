package collection.arrays;

import data.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ArraysSorting {

    public static void main(String[] args) {
        sortArrays();
    }

    private static void sortArrays() {
        String fileName = FilesEnum.SalesRecords5M.toString();
        //sortArraysNaturalOrder(fileName);
        sortArraysNaturalOrderWithFunction(fileName);
        sortArrayNaturalOrderUisngComparator(fileName);
        //sortArrayReverse(fileName);
    }
    private static void sortArraysNaturalOrder(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        SalesVO[] newArray1 = salesArr;
        Arrays.sort(newArray1, Comparator.comparing(SalesVO::getOrderID));
        Arrays.sort(newArray1, Comparator.comparing(p -> p.getOrderID()));
        long end = new Date().getTime();
        log.info("Time taken :" +(end-start));
        System.out.println("First Value -1 :"+newArray1[0].getOrderID()+"    Last Value-1 :"+newArray1[newArray1.length-1].getOrderID());
        salesArr = null;
    }

    private static void sortArraysNaturalOrderWithFunction(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        // Functions for getting first and last names from an Employee
        Function<SalesVO, Integer> funcbyOrderId = SalesVO::getOrderID;
        Function<SalesVO, String> functbyCountry = SalesVO::getCountry;
        // Comparator for comparing Sales by OrderId  then country
        Comparator<SalesVO> comparestr = Comparator.comparing(funcbyOrderId).thenComparing(functbyCountry);
        // sort employees in descending order by last name, then first name
        Arrays.stream(salesArr).sorted(comparestr);
        long end = new Date().getTime();
        log.info("Time taken :" +(end-start));
        System.out.println("First Value -2 :"+salesArr[0].getOrderID()+"    Last Value-2 :"+salesArr[salesArr.length-1].getOrderID());

        salesArr = null;

    }
    //This is best performance
    private static void sortArrayNaturalOrderUisngComparator(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        Comparator<SalesVO> compareByRevenue = (SalesVO o1, SalesVO o2) -> o1.getTotalRevenue().compareTo( o2.getTotalRevenue() );
        Arrays.stream(salesArr).sorted(compareByRevenue);
        long end = new Date().getTime();
        log.info("Time taken :" +(end-start));
        System.out.println("First Value- 3 :"+salesArr[0].getOrderID()+"    Last Value - 3 :"+salesArr[salesArr.length-1].getOrderID());
        salesArr = null;

    }

    private static void sortArrayReverse(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        Function<SalesVO, Integer> funcbyOrderId = SalesVO::getOrderID;
        Arrays.sort(salesArr, Collections.reverseOrder(Comparator.comparing(funcbyOrderId)));
        long end = new Date().getTime();
        log.info("Time taken :" +(end-start));
        System.out.println("First Value- 4 :"+salesArr[0].getOrderID()+"    Last Value - 4 :"+salesArr[salesArr.length-1].getOrderID());
        salesArr = null;

    }


    private static void sortArraysDifferently() throws IOException {

        Comparator<Employee> empIdSorter = (a, b) -> a.getEmpId().compareTo(b.getEmpId());
        List<Employee> lstEmp = GetEmployeeData.getEmployeeListWithfewRecords().stream().sorted(empIdSorter).collect(Collectors.toList());
        Employee[] empArray = new Employee[lstEmp.size()];
        empArray = lstEmp.toArray(empArray);
        Arrays.sort(empArray, Comparator.comparing(Employee::getEmpId));  // two ways to comparing
        for (Employee emp : empArray) {
            System.out.println("Arrays ID  :" + emp.getEmpId());
        }
        Comparator<Employee> nameSorter = (a, b) -> a.getUserName().compareToIgnoreCase(b.getUserName());
        Arrays.sort(empArray, nameSorter);
        for (Employee emp : empArray) {
            System.out.println("Arrays username  :" + emp.getUserName());
        }
    }
}
