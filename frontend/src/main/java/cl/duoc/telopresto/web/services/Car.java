package cl.duoc.telopresto.web.services;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
  private int id;
  private String plateCode;
  private String brand;
  private String model;
  private String subsidiary;
  private Integer subsidiaryId;
  private String color;
  private Integer year;
  private Integer capacity;
  private Integer cost;
  private String type;
  private String image;
  private List<CarComment> comments;
}
