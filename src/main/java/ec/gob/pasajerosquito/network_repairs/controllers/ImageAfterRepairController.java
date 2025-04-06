package ec.gob.pasajerosquito.network_repairs.controllers;

import ec.gob.pasajerosquito.network_repairs.constants.GlobalConstant;
import ec.gob.pasajerosquito.network_repairs.dto.ImageAfterRepairDTO;
import ec.gob.pasajerosquito.network_repairs.dto.http.ListResponse;
import ec.gob.pasajerosquito.network_repairs.services.ImageAfterRepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GlobalConstant.IMAGE_AFTER_REPAIR_PATH)
public class ImageAfterRepairController {

    private final ImageAfterRepairService imageAfterRepairService;

    @GetMapping
    public ListResponse<ImageAfterRepairDTO> getAllImages() {
        log.info("{} : getAll", GlobalConstant.IMAGE_AFTER_REPAIR_PATH);
        return new ListResponse<>(imageAfterRepairService.getAll());
    }

    @GetMapping("/{id}")
    public ImageAfterRepairDTO getImageById(@PathVariable long id) {
        log.info("{} : getById", GlobalConstant.IMAGE_AFTER_REPAIR_PATH);
        return imageAfterRepairService.getById(id);
    }

    @PostMapping
    public ImageAfterRepairDTO createImage(@RequestBody ImageAfterRepairDTO imageAfterRepairDTO) {
        log.info("{} : create", GlobalConstant.IMAGE_AFTER_REPAIR_PATH);
        return imageAfterRepairService.create(imageAfterRepairDTO);
    }

    @PutMapping
    public ImageAfterRepairDTO updateImage(@RequestBody ImageAfterRepairDTO imageAfterRepairDTO) {
        log.info("{} : update", GlobalConstant.IMAGE_AFTER_REPAIR_PATH);
        return imageAfterRepairService.update(imageAfterRepairDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable long id) {
        log.info("{} : delete", GlobalConstant.IMAGE_AFTER_REPAIR_PATH);
        imageAfterRepairService.delete(id);
    }
}
