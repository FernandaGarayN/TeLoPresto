package cl.duoc.newrentacar.api.repository;


import cl.duoc.newrentacar.api.repository.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
        extends CrudRepository<CarEntity, Integer> {
}
