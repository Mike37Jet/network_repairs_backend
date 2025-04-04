package ec.gob.pasajerosquito.network_repairs.controllers;

import ec.gob.pasajerosquito.network_repairs.constants.GlobalConstant;
import ec.gob.pasajerosquito.network_repairs.services.MinioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GlobalConstant.MINIO_PATH)
public class MinioController {

    private final MinioService minioService;

    @GetMapping("/url")
    public ResponseEntity<String> getPreSignedObjectUrl(@RequestParam("objectName") String objectName) {
        log.info("Obteniendo URL pre-firmada para el objeto: {}", objectName);
        String url = minioService.getPreSignedObjectUrl(objectName);
        return ResponseEntity.ok(url);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<Map<String, String>> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("repairId") String repairId,
            @RequestParam("objectName") String objectName) {
        log.info("Subiendo imagen con repairId: {} y nombre de objeto: {}", repairId, objectName);
        String newObjectName = minioService.uploadImage(file, repairId, objectName);
        Map<String, String> response = new HashMap<>();
        if (newObjectName != null) {
            response.put("objectName", newObjectName);
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Error al subir la imagen");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFile(@RequestParam("objectName") String objectName) {
        log.info("Eliminando archivo con nombre de objeto: {}", objectName);
        minioService.removeFile(objectName);
        return ResponseEntity.ok().build();
    }
}
