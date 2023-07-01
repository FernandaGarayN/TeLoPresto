package cl.duoc.newrentacar.endpoint;

import cl.duoc.newrentacar.endpoint.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCarResponse {
    private Car car;
}
