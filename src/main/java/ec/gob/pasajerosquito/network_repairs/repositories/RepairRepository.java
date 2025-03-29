package ec.gob.pasajerosquito.network_repairs.repositories;

import ec.gob.pasajerosquito.network_repairs.entities.postgres.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    @Query("SELECT r FROM Repair r " +
            "WHERE r.id = :id " +
            "AND (r.deletedAt IS NULL OR r.deletedAt > CURRENT_TIMESTAMP)")
    Optional<Repair> findValidById(Long id);

    @Query("FROM Repair " +
            "WHERE deletedAt IS NULL " +
            "OR deletedAt > CURRENT_TIMESTAMP")
    List<Repair> findAllValid();

}
