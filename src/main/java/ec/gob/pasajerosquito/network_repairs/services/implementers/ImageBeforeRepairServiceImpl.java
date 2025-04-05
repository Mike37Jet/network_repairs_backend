package ec.gob.pasajerosquito.network_repairs.services.implementers;

import ec.gob.pasajerosquito.network_repairs.dto.ImageBeforeRepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.ImageBeforeRepair;
import ec.gob.pasajerosquito.network_repairs.exceptions.NetworkRepairsException;
import ec.gob.pasajerosquito.network_repairs.mappers.ImageBeforeRepairMapper;
import ec.gob.pasajerosquito.network_repairs.repositories.ImageBeforeRepairRepository;
import ec.gob.pasajerosquito.network_repairs.services.ImageBeforeRepairService;
import ec.gob.pasajerosquito.network_repairs.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageBeforeRepairServiceImpl implements ImageBeforeRepairService {

    private final ImageBeforeRepairRepository imageBeforeRepairRepository;
    private final ImageBeforeRepairMapper imageBeforeRepairMapper;

    @Override
    public List<ImageBeforeRepairDTO> getAll() {
        return imageBeforeRepairMapper.toListDTO(imageBeforeRepairRepository.findAllValid());
    }

    @Override
    public ImageBeforeRepairDTO getById(long id) {
        return imageBeforeRepairMapper.toDTO(getImageBeforeRepairById(id));
    }

    @Override
    public ImageBeforeRepairDTO create(ImageBeforeRepairDTO imageBeforeRepairDTO) {
        return imageBeforeRepairMapper.toDTO(
                imageBeforeRepairRepository.save(
                        imageBeforeRepairMapper.toEntity(imageBeforeRepairDTO)
                )
        );
    }

    @Override
    public ImageBeforeRepairDTO update(ImageBeforeRepairDTO imageBeforeRepairDTO) {
        // Validar que la imagen exista
        getImageBeforeRepairById(imageBeforeRepairDTO.getId());
        ValidationUtils.validateId(imageBeforeRepairDTO.getId(), "ImageBeforeRepair", "Imagen previa a la reparación");

        return imageBeforeRepairMapper.toDTO(
                imageBeforeRepairRepository.save(
                        imageBeforeRepairMapper.toEntity(imageBeforeRepairDTO)
                )
        );
    }

    @Override
    public void delete(long id) {
        ImageBeforeRepair imageBeforeRepair = getImageBeforeRepairById(id);
        imageBeforeRepair.setDeletedAt(LocalDateTime.now());
        imageBeforeRepairRepository.save(imageBeforeRepair);
    }

    private ImageBeforeRepair getImageBeforeRepairById(long id) {
        return imageBeforeRepairRepository.findValidById(id).orElseThrow(() -> {
            log.error("Valid ImageBeforeRepair not found for id: {}", id);
            return new NetworkRepairsException("No se encontró la Imagen previa a la reparación para el id especificado");
        });
    }
}
