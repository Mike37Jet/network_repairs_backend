package ec.gob.pasajerosquito.network_repairs.controllers;

import ec.gob.pasajerosquito.network_repairs.constants.GlobalConstant;
import ec.gob.pasajerosquito.network_repairs.dto.RepairDTO;
import ec.gob.pasajerosquito.network_repairs.dto.http.ListResponse;
import ec.gob.pasajerosquito.network_repairs.services.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GlobalConstant.REPAIR_PATH)
public class RepairController {
    private final RepairService repairService;

    @GetMapping
    public ListResponse<RepairDTO> getAllRepairs() {
        log.info("{} : getAll", GlobalConstant.REPAIR_PATH);
        return new ListResponse<>(repairService.getAll());
    }

    @GetMapping("/{id}")
    public RepairDTO getRepairById(@PathVariable long id) {
        log.info("{} : getById", GlobalConstant.REPAIR_PATH);
        return repairService.getById(id);
    }

    @PostMapping
    public RepairDTO createRepair(@RequestBody RepairDTO repairDTO) {
        log.info("{} : create", GlobalConstant.REPAIR_PATH);
        return repairService.create(repairDTO);
    }

    @PutMapping
    public RepairDTO updateRepair(@RequestBody RepairDTO repairDTO) {
        log.info("{} : update", GlobalConstant.REPAIR_PATH);
        return repairService.update(repairDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRepair(@PathVariable long id) {
        log.info("{} : delete", GlobalConstant.REPAIR_PATH);
        repairService.delete(id);
    }


}
