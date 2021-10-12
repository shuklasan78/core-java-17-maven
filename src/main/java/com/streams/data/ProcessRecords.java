package com.streams.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessRecords {

    public static void main(String[] args) {
        ProcessRecords o1 = new ProcessRecords();
        //System.out.println(readEmployeesFromCSV(""));
    }

    public static List<Employee> readEmployeesFromCSV(String filename) {
        String fileName = filename;
        if(filename.isEmpty()) {
            fileName = "/Users/sandeepkumarshukla/Applications/Technical/Intellij/core-java-17/src/com/java/practice/streams/data/person50krecords.csv";
        } else {
            fileName = "/Users/sandeepkumarshukla/Applications/Technical/Intellij/core-java-17/src/com/java/practice/streams/data/"+fileName+".csv";

        }
        List<Employee> employees = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = line.replaceFirst(",", " , ");
            while (line != null) {
                    String[] attributes = line.split(",");

                    Employee employee = createEmployee(attributes);
                    if(null!=employee) {
                        employees.add(employee);
                    }
                    line = br.readLine();
            }
        } catch (IOException ioe) { ioe.printStackTrace(); }
        return employees;
    }


    private static Employee createEmployee(String[] metadata) {

            if(isNumeric(metadata[0])) {
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
            }
            else {
                return null;
            }


        }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static List<Person> getPerson() {
        String fileName = "/Users/sandeepkumarshukla/Applications/Technical/Intellij/core-java-17/src/com/java/practice/streams/data/person.csv";
        List<Person> persons = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");

                Person person = createPerson(attributes);
                persons.add(person);
                line = br.readLine();
            }
        } catch (IOException ioe) { ioe.printStackTrace(); }
        return persons;
    }
    private static Person createPerson(String[] attributes) {
         String name= attributes[0];
         Integer age= Integer.valueOf(attributes[1]) ;
         String address=attributes[2] ;
         String phone=  attributes[3];
         String email= (attributes[4]);
         String birthday= attributes[5];
         String city= attributes[6];
        Person person  = new Person(name,age,address,phone,email,birthday,city);
        return person;
    }
}
