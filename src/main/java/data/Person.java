package data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String address;
    private String phone;
    private String email;
    private String birthday;
    private String city;
}
