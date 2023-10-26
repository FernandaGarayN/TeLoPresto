package cl.duoc.telopresto.web.services;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private int id;
    private String plateCode;
    private String brand;
    private String model;
    private String subsidiary;
    private String color;
    private Integer year;
    private Integer capacity;
    private Integer cost;
    private String type;
}