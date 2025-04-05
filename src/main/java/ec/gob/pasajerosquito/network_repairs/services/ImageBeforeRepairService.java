package ec.gob.pasajerosquito.network_repairs.services;

import ec.gob.pasajerosquito.network_repairs.dto.ImageBeforeRepairDTO;

import java.util.List;

public interface ImageBeforeRepairService {

    List<ImageBeforeRepairDTO> getAll();
    ImageBeforeRepairDTO getById(long id);
    ImageBeforeRepairDTO create(ImageBeforeRepairDTO imageBeforeRepairDTO);
    ImageBeforeRepairDTO update(ImageBeforeRepairDTO imageBeforeRepairDTO);
    void delete(long id);
}
