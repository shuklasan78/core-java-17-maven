package data;

import data.Employee;
import data.SalesVO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVDataProcessor {

    static String filePath = "/Users/sandeepkumarshukla/Applications/Technical/core-java-17-maven/src/main/resources/";

    public static void main(String[] args) throws IOException {
        System.out.println("Size of the records are :"+readSalesCSVFile("SalesRecords5M").size());
        System.out.println("Size of the records are :"+readEmployeesCSVFile("EmployeeRecords1M").size());

    }

    public static List<SalesVO> readSalesCSVFile(String csvName) {
        List<SalesVO> inputList = new ArrayList<SalesVO>();
        //var filePath = System.getProperty("user.dir") + "/resources/SalesRecord100.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath+csvName+".csv"))) {
            inputList = br.lines().skip(1).map(mapToSalesItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }
    public static List<Employee> readEmployeesCSVFile(String csvName)  {
        List<Employee> inputList = new ArrayList<>();
        //var filePath = System.getProperty("user.dir") + "/resources/SalesRecord100.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath+csvName+".csv"))) {
            inputList = br.lines().skip(1).map(mapToEmployeeItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }
    private static Function<String, SalesVO> mapToSalesItem = (line) -> {
        String[] p = line.split(",");// a CSV has comma separated lines
        SalesVO item = new SalesVO();
        item.setRegion(p[0]);
        item.setCountry(p[1]);
        item.setItemType(p[2]);
        item.setSalesChannel(p[3]);
        item.setOrderPriority(p[4]);
        item.setOrderDate(p[5]);
        item.setOrderID(Integer.valueOf(p[6]));
        item.setShipDate(p[7]);
        item.setUnitsSold(Integer.valueOf(p[8]));
        item.setUnitPrice(Double.valueOf(p[9]));
        item.setUnitCost(Double.valueOf(p[10]));
        item.setTotalRevenue(Double.valueOf(p[11]));
        item.setTotalCost(Double.valueOf(p[12]));
        item.setTotalProfit(Double.valueOf(p[13]));
        return item;
    };

    private static Function<String, Employee> mapToEmployeeItem = (line) -> {
        String[] metadata = line.split(",");// a CSV has comma separated lines
        Employee employee = new Employee();
        Integer empId = Integer.valueOf(metadata[0].trim());
        String namePrefix = metadata[1];
        String firstname = metadata[2];
        String middleInitial = metadata[3];
        String lastName = metadata[4];
        String gender = metadata[5];
        String email = metadata[6];
        String fatherName = metadata[7];
        String motherName = metadata[8];
        String motherMaidenName = metadata[9];
        String dateOfBirth = metadata[10];
        String timeOfBirth = metadata[11];
        double ageInYrs = Double.valueOf(metadata[12]);
        Integer weightInKgs =Integer.valueOf(metadata[13]);
        String dateOfJoining = metadata[14];
        String quarterOfJoining =(metadata[15]);
        String halfOfJoining = metadata[16];
        Integer yearOfJoining = Integer.valueOf(metadata[17]);
        String monthOfJoining = (metadata[18]);
        String monthNameOfJoining = metadata[19];
        String shortMonth = metadata[20];
        String dayOfJoining = (metadata[21]);
        String dowOfJoining = metadata[22];
        String shortDOW = metadata[23];
        double ageInCompany = Double.valueOf(metadata[24]);
        Integer salary = Integer.valueOf(metadata[25]);
        String LastPercentike =(metadata[26]);
        String SSN = (metadata[27]);
        String phoneNo =(metadata[28]);
        String plcaseName = metadata[29];
        String county = metadata[30];
        String city = metadata[31];
        String state = metadata[32];
        String zip = metadata[33];
        String region = metadata[34];
        String userName = metadata[35];
        String password = metadata[36];
        employee.setEmpId(empId);
        employee.setNamePrefix(namePrefix);
        employee.setFirstname(firstname);
        employee.setMiddleInitial(middleInitial);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setFirstname(fatherName);
        employee.setMotherName(motherName);
        employee.setMotherMaidenName(motherMaidenName);
        employee.setDateOfBirth(dateOfBirth);
        employee.setTimeOfBirth(timeOfBirth);
        employee.setAgeInYrs(ageInYrs);
        employee.setWeightInKgs(weightInKgs);
        employee.setDateOfJoining(dateOfJoining);
        employee.setQuarterOfJoining(quarterOfJoining);
        employee.setHalfOfJoining(halfOfJoining);
        employee.setYearOfJoining(yearOfJoining);
        employee.setMonthOfJoining(monthOfJoining);
        employee.setShortMonth(shortMonth);
        employee.setDayOfJoining(dayOfJoining);
        employee.setDowOfJoining(dowOfJoining);
        employee.setShortDOW(shortDOW);
        employee.setAgeInCompany(ageInCompany);
        employee.setSalary(salary);
        employee.setLastPercentike(LastPercentike);
        employee.setSSN(SSN);
        employee.setPhoneNo(phoneNo);
        employee.setPlcaseName(plcaseName);
        employee.setCounty(county);
        employee.setState(state);
        employee.setZip(zip);
        employee.setRegion(region);
        employee.setUserName(userName);
        employee.setPassword(password);
        return employee;
    };
}
