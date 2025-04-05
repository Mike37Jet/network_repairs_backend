package ec.gob.pasajerosquito.network_repairs.repositories;

import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageBeforeRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageBeforeRepairRepository extends JpaRepository<ImageBeforeRepair, Long> {
    @Query("SELECT i FROM ImageBeforeRepair i " +
            "WHERE i.id = :id " +
            "AND (i.deletedAt IS NULL OR i.deletedAt > CURRENT_TIMESTAMP)")
    Optional<ImageBeforeRepair> findValidById(Long id);

    @Query("FROM ImageBeforeRepair " +
            "WHERE deletedAt IS NULL " +
            "OR deletedAt > CURRENT_TIMESTAMP")
    List<ImageBeforeRepair> findAllValid();

}
