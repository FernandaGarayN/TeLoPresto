package cl.duoc.newrentacar.api.repository;

import cl.duoc.newrentacar.api.repository.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
  Optional<ClientEntity> findByUsername(String username);
}
