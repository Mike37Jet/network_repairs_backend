package ec.gob.pasajerosquito.network_repairs.controllers;

import ec.gob.pasajerosquito.network_repairs.constants.GlobalConstant;
import ec.gob.pasajerosquito.network_repairs.dto.ImageBeforeRepairDTO;
import ec.gob.pasajerosquito.network_repairs.dto.http.ListResponse;
import ec.gob.pasajerosquito.network_repairs.services.ImageBeforeRepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GlobalConstant.IMAGE_BEFORE_REPAIR_PATH)
public class ImageBeforeRepairController {

    private final ImageBeforeRepairService imageBeforeRepairService;

    @GetMapping
    public ListResponse<ImageBeforeRepairDTO> getAllImages() {
        log.info("{} : getAll", GlobalConstant.IMAGE_BEFORE_REPAIR_PATH);
        return new ListResponse<>(imageBeforeRepairService.getAll());
    }

    @GetMapping("/{id}")
    public ImageBeforeRepairDTO getImageById(@PathVariable long id) {
        log.info("{} : getById", GlobalConstant.IMAGE_BEFORE_REPAIR_PATH);
        return imageBeforeRepairService.getById(id);
    }

    @PostMapping
    public ImageBeforeRepairDTO createImage(@RequestBody ImageBeforeRepairDTO imageBeforeRepairDTO) {
        log.info("{} : create", GlobalConstant.IMAGE_BEFORE_REPAIR_PATH);
        return imageBeforeRepairService.create(imageBeforeRepairDTO);
    }

    @PutMapping
    public ImageBeforeRepairDTO updateImage(@RequestBody ImageBeforeRepairDTO imageBeforeRepairDTO) {
        log.info("{} : update", GlobalConstant.IMAGE_BEFORE_REPAIR_PATH);
        return imageBeforeRepairService.update(imageBeforeRepairDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable long id) {
        log.info("{} : delete", GlobalConstant.IMAGE_BEFORE_REPAIR_PATH);
        imageBeforeRepairService.delete(id);
    }
}
