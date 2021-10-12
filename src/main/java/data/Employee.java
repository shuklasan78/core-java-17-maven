package data;

import lombok.*;

@Data @AllArgsConstructor @ToString
public class Employee {
    private Integer empId;
    private String namePrefix;
    private String firstname;
    private String middleInitial;
    private String lastName;
    private String Gender;
    private String email;
    private String fatherName;
    private String motherName;
    private String motherMaidenName;
    private String dateOfBirth;
    private String timeOfBirth;
    private double ageInYrs;
    private double weightInKgs;
    private String dateOfJoining;
    private String quarterOfJoining;
    private String halfOfJoining;
    private Integer yearOfJoining;
    private String monthOfJoining;
    private String monthNameOfJoining;
    private String shortMonth;
    private String dayOfJoining;
    private String dowOfJoining;
    private String shortDOW;
    private double ageInCompany;
    private Integer salary;
    private String LastPercentike;
    private String SSN;
    private String phoneNo;
    private String plcaseName;
    private String county;
    private String city;
    private String state;
    private String zip;
    private String region;
    private String userName;
    private String password;


    public Employee() {

    }

    public Employee(Employee employee) {
    }
}
