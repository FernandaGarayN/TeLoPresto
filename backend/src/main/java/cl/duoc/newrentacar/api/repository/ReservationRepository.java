package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
  List<ReservationEntity> findByClientUsername(String userName);

  List<ReservationEntity> findByClientUsernameAndStatus(String userName, String status);
}
