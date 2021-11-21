package collection.map;

import data.*;

import java.util.*;
import java.util.stream.Collectors;

public class MapAdvancedStream {
    public static void main(String[] args) {
        String records = FilesEnum.SalesRecords1000.toString();
        convertMapToCollections(records);
    }

    private static void convertMapToCollections(String records) {

        createListFromMap(records);
        createSetFromMap(records);
        createArraysFromMap(records);
        identifyMathsDetailsFromList();
    }

    private static void identifyMathsDetailsFromList() {
        List<Employee> employeeList = GetEmployeeData.getEmployeeListWithfewRecords();
        //Identify Number of males and female in the List :
        Map<String, Long> noOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Number fo Male and Female fromt he List : "+noOfMaleAndFemaleEmployees);

        //Average age of the Man and Women
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAgeInYrs)));
        System.out.println("Average age of the man and women : "+avgAgeOfMaleAndFemaleEmployees);

        //Find highest paid employer
        Optional<Employee> highestPaidEmployeeWrapper=
                employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
        System.out.println("Highest Paid Employer ID   :"+highestPaidEmployee.getEmpId()+"   Name  :"+highestPaidEmployee.getFirstname()+"    Salary  :"+highestPaidEmployee.getSalary() );

        //find youngest employer
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
                employeeList.stream()
                        .filter(e -> e.getGender().equalsIgnoreCase("M"))
                        .min(Comparator.comparingDouble(Employee::getAgeInYrs));
        Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();
        System.out.println("Youngest Employer Salary is :"+youngestMaleEmployeeInProductDevelopment.getSalary());
    }

    private static void createArraysFromMap(String records) {

    }

    private static void createSetFromMap(String records) {
    }

    private static void createListFromMap(String records) {

        Map<Integer, SalesVO> salesMap = GetSalesData.getSalesMap(records);

        //Convert map keys into List
        List<Integer> arrlist = salesMap.keySet()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));

        //Convert map keys into List of Integer fter sorting
        arrlist = salesMap.keySet()
                .stream().sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        //arrlist.forEach(System.out::println);

        //Convert Map into Sales Object which is basically values of the Map
        List<SalesVO> listArrayEmp = salesMap.values()
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));
        //System.out.println("ListArraEmp :"+listArrayEmp);
    }

}
