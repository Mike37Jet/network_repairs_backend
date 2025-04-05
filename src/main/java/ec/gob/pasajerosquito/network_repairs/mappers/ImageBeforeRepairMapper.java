package ec.gob.pasajerosquito.network_repairs.mappers;

import ec.gob.pasajerosquito.network_repairs.annotations.IgnoreAuditFields;
import ec.gob.pasajerosquito.network_repairs.dto.ImageBeforeRepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageBeforeRepair;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageBeforeRepairMapper {
    @IgnoreAuditFields
    ImageBeforeRepair toEntity(ImageBeforeRepairDTO imageBeforeRepairDTO);
    ImageBeforeRepairDTO toDTO(ImageBeforeRepair imageBeforeRepair);
    List<ImageBeforeRepairDTO> toListDTO(List<ImageBeforeRepair> imageBeforeRepairs);
}
