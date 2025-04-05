package ec.gob.pasajerosquito.network_repairs.repositories;

import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageAfterRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageAfterRepairRepository extends JpaRepository<ImageAfterRepair, Long> {
    @Query("SELECT i FROM ImageAfterRepair i " +
            "WHERE i.id = :id " +
            "AND (i.deletedAt IS NULL OR i.deletedAt > CURRENT_TIMESTAMP)")
    Optional<ImageAfterRepair> findValidById(Long id);

    @Query("FROM ImageAfterRepair " +
            "WHERE deletedAt IS NULL " +
            "OR deletedAt > CURRENT_TIMESTAMP")
    List<ImageAfterRepair> findAllValid();
}
