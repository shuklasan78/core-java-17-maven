package collection.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String type;
    private String color;
}
