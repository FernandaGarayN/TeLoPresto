package cl.duoc.newrentacar.endpoint;

import cl.duoc.newrentacar.endpoint.model.Car;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCarsResponse {
    private List<Car> cars;
}
