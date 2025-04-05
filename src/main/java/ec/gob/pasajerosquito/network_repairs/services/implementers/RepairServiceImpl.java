package ec.gob.pasajerosquito.network_repairs.services.implementers;

import ec.gob.pasajerosquito.network_repairs.dto.RepairDTO;
import ec.gob.pasajerosquito.network_repairs.entities.postgres.Repair;
import ec.gob.pasajerosquito.network_repairs.exceptions.NetworkRepairsException;
import ec.gob.pasajerosquito.network_repairs.mappers.RepairMapper;
import ec.gob.pasajerosquito.network_repairs.repositories.RepairRepository;
import ec.gob.pasajerosquito.network_repairs.services.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ec.gob.pasajerosquito.network_repairs.utils.ValidationUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;
    private final RepairMapper repairMapper;

    @Override
    public List<RepairDTO> getAll() {
        return repairMapper.toListDTO(repairRepository.findAllValid());
    }

    @Override
    public RepairDTO getById(long id) {
        return repairMapper.toDTO(this.getRepairById(id));
    }

    @Override
    public RepairDTO create(RepairDTO repairDTO) {
        return repairMapper.toDTO(repairRepository.save(repairMapper.toEntity(repairDTO)));
    }

    @Override
    public RepairDTO update(RepairDTO repairDTO) {
        this.getRepairById(repairDTO.getId());
        ValidationUtils.validateId(repairDTO.getId(), "Repair", "Reparación");
        return repairMapper.toDTO(repairRepository.save(repairMapper.toEntity(repairDTO)));
    }

    @Override
    public void delete(long id) {
        Repair repair = this.getRepairById(id);
        repair.setDeletedAt(LocalDateTime.now());
        repairRepository.save(repair);
    }

    private Repair getRepairById(long id) {
        return repairRepository.findValidById(id).orElseThrow(() -> {
            log.error("Valid Repair not found for id: {}", id);
            return new NetworkRepairsException("No se encontró la Reparación para el id especificado");
        });
    }
}
