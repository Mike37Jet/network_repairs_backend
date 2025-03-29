package ec.gob.pasajerosquito.network_repairs.services;

import ec.gob.pasajerosquito.network_repairs.dto.RepairDTO;

import java.util.List;

public interface RepairService {

    List<RepairDTO> getAll();
    RepairDTO getById(long id);
    RepairDTO create(RepairDTO repairDTO);
    RepairDTO update(RepairDTO repairDTO);
    void delete(long id);
}
