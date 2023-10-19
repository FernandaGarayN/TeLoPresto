package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCarResponse {
    private Car car;
}
