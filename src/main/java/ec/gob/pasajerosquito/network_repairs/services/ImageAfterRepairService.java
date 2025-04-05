package ec.gob.pasajerosquito.network_repairs.services;

import ec.gob.pasajerosquito.network_repairs.dto.ImageAfterRepairDTO;

import java.util.List;

public interface ImageAfterRepairService {

    List<ImageAfterRepairDTO> getAll();
    ImageAfterRepairDTO getById(long id);
    ImageAfterRepairDTO create(ImageAfterRepairDTO imageAfterRepairDTO);
    ImageAfterRepairDTO update(ImageAfterRepairDTO imageAfterRepairDTO);
    void delete(long id);
}
