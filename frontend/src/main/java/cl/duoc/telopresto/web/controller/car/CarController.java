package cl.duoc.telopresto.web.controller.car;

import cl.duoc.telopresto.web.services.Car;
import cl.duoc.telopresto.web.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping("/busqueda-vehiculos")
    public String getBusquedaVehiculos(ModelMap model){
        model.addAttribute("carSearchForm", CarSearchForm.builder().build());
        return "busqueda-vehiculos";
    }
    @PostMapping("/busqueda-vehiculos")
    public String postBusquedaVehiculos(ModelMap model,
                                    @Valid @ModelAttribute("carSearchForm") CarSearchForm carSearchForm,
                                    BindingResult bindingResult) {
        model.addAttribute("carSearchForm", carSearchForm);
        if (!bindingResult.hasErrors()) {
            List<Car> cars = carService.searchCars(carSearchForm);
            model.addAttribute("results", cars);
        }

        return "busqueda-vehiculos";
    }

    @GetMapping("/detalle-vehiculo")
    public String getDetalleVehiculo(ModelMap model, @RequestParam("idVehiculo") Integer idVehiculo){
        Car car = carService.findById(idVehiculo);
        model.addAttribute("car",car);
        return "detalle-vehiculo";
    }

}
