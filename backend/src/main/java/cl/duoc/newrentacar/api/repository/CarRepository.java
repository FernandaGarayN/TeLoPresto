package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {

  @Query("""
    select c from CarEntity c
    where (c.brand = ?1 or ?1 = '' or ?1 is null)
    and (c.model = ?2 or ?2 = '' or ?2 is null)
    and (c.color = ?3 or ?3 = '' or ?3 is null)
    and (c.year = ?4 or ?4 is null)
    and (c.subsidiary.name = ?5 or ?5 = '' or ?5 is null)
    and (c.dailyCost <= ?6 or ?6 is null)
    """)
  List<CarEntity> findCars(String brand, String model, String color, Integer year, String name, Integer dailyCost);
}
