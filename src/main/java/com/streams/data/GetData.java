package com.streams.data;

import java.util.List;

public class GetData {

    public static List<Employee> getListWithfewRecords() {
        List<Employee> originalList = ProcessRecords.readEmployeesFromCSV("personfewrecords");
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
}
