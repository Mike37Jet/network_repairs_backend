package ec.gob.pasajerosquito.network_repairs.mappers;

import ec.gob.pasajerosquito.network_repairs.annotations.IgnoreAuditFields;
import ec.gob.pasajerosquito.network_repairs.dto.RepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.Repair;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface RepairMapper {
    @IgnoreAuditFields
    Repair toEntity(RepairDTO repairDTO);

    RepairDTO toDTO(Repair repair);

    List<RepairDTO> toListDTO(List<Repair> repairs);
}
