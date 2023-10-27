package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.CarEntity;
import cl.duoc.newrentacar.api.repository.model.SubsidiaryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiaryRepository extends CrudRepository<SubsidiaryEntity, Integer> {
}
