package cl.duoc.newrentacar.repository;


import cl.duoc.newrentacar.repository.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
        extends CrudRepository<CarEntity, Integer> {
}
