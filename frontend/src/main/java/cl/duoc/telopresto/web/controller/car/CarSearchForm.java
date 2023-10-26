package cl.duoc.telopresto.web.controller.car;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CarSearchForm {
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private String subsidiary;
    private Integer price;
}
