package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {
  List<CarEntity> findByBrandOrModelOrColorOrYearOrSubsidiaryNameOrDailyCostLessThanEqual(
          String brand, String model, String color, Integer year, String subsidiary, Integer dailyCost);
}
