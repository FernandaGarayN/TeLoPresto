package cl.duoc.newrentacar.api.endpoint;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.endpoint.model.Subsidiary;
import cl.duoc.newrentacar.api.service.CarService;
import cl.duoc.newrentacar.api.service.SubsidiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubsidiaryController {
    @Autowired
    private SubsidiaryService subsidiaryService;
    @GetMapping("/subsidiaries/names")
    public ResponseEntity<List<String>> getNames() {
        List<Subsidiary> subsidiaries = subsidiaryService.getAllSubsidiaries();
        List<String> names = new ArrayList<>();
        for(Subsidiary subsidiary: subsidiaries){
            if (!names.contains(subsidiary.getName())){
                names.add(subsidiary.getName());
            }
        }
        return ResponseEntity.ok(names);
    }
}
