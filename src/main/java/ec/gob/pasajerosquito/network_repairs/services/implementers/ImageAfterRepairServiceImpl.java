package ec.gob.pasajerosquito.network_repairs.services.implementers;

import ec.gob.pasajerosquito.network_repairs.dto.ImageAfterRepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageAfterRepair;
import ec.gob.pasajerosquito.network_repairs.exceptions.NetworkRepairsException;
import ec.gob.pasajerosquito.network_repairs.mappers.ImageAfterRepairMapper;
import ec.gob.pasajerosquito.network_repairs.repositories.ImageAfterRepairRepository;
import ec.gob.pasajerosquito.network_repairs.services.ImageAfterRepairService;
import ec.gob.pasajerosquito.network_repairs.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageAfterRepairServiceImpl implements ImageAfterRepairService {

    private final ImageAfterRepairRepository imageAfterRepairRepository;
    private final ImageAfterRepairMapper imageAfterRepairMapper;

    @Override
    public List<ImageAfterRepairDTO> getAll() {
        return imageAfterRepairMapper.toListDTO(imageAfterRepairRepository.findAllValid());
    }

    @Override
    public ImageAfterRepairDTO getById(long id) {
        return imageAfterRepairMapper.toDTO(this.getImageById(id));
    }

    @Override
    public ImageAfterRepairDTO create(ImageAfterRepairDTO imageAfterRepairDTO) {
        return imageAfterRepairMapper.toDTO(
                imageAfterRepairRepository.save(
                        imageAfterRepairMapper.toEntity(imageAfterRepairDTO)
                )
        );
    }

    @Override
    public ImageAfterRepairDTO update(ImageAfterRepairDTO imageAfterRepairDTO) {
        this.getImageById(imageAfterRepairDTO.getId());
        ValidationUtils.validateId(imageAfterRepairDTO.getId(), "ImageAfterRepair", "Imagen posterior a la reparación");

        return imageAfterRepairMapper.toDTO(
                imageAfterRepairRepository.save(
                        imageAfterRepairMapper.toEntity(imageAfterRepairDTO)
                )
        );
    }

    @Override
    public void delete(long id) {
        ImageAfterRepair imageAfterRepair = getImageById(id);
        imageAfterRepair.setDeletedAt(LocalDateTime.now());
        imageAfterRepairRepository.save(imageAfterRepair);
    }

    private ImageAfterRepair getImageById(long id) {
        return imageAfterRepairRepository.findValidById(id).orElseThrow(() -> {
            log.error("Valid ImageAfterRepair not found for id: {}", id);
            return new NetworkRepairsException("No se encontró la Imagen posterior a la reparación para el id especificado");
        });
    }
}
