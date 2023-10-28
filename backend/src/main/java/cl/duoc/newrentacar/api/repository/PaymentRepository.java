package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {
    List<PaymentEntity> findByReservationClientUsername(String userName);
}
