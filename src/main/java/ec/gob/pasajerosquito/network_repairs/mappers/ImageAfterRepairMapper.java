package ec.gob.pasajerosquito.network_repairs.mappers;

import ec.gob.pasajerosquito.network_repairs.annotations.IgnoreAuditFields;
import ec.gob.pasajerosquito.network_repairs.dto.ImageAfterRepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageAfterRepair;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageAfterRepairMapper {

    @IgnoreAuditFields
    ImageAfterRepair toEntity(ImageAfterRepairDTO imageAfterRepairDTO);
    ImageAfterRepairDTO toDTO(ImageAfterRepair imageAfterRepair);
    List<ImageAfterRepairDTO> toListDTO(List<ImageAfterRepair> imageAfterRepairs);

}
