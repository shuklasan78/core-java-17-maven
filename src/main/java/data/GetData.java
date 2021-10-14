package data;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
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
}
