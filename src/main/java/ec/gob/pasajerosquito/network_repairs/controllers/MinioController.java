package ec.gob.pasajerosquito.network_repairs.controllers;

import ec.gob.pasajerosquito.network_repairs.constants.GlobalConstant;
import ec.gob.pasajerosquito.network_repairs.services.MinioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GlobalConstant.MINIO_PATH)
public class MinioController {

    private final MinioService minioService;

    @GetMapping("/url/{objectName}")
    public ResponseEntity<String> getPreSignedObjectUrl(@PathVariable String objectName) {
        log.info("Obteniendo URL pre-firmada para el objeto: {}", objectName);
        String url = minioService.getPreSignedObjectUrl(objectName);
        return ResponseEntity.ok(url);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<Boolean> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("objectName") String objectName) {
        log.info("Subiendo imagen con nombre de objeto: {}", objectName);
        boolean result = minioService.uploadImage(file, objectName);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/upload-file")
    public ResponseEntity<Void> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("objectName") String objectName,
            @RequestParam("contentType") String contentType) {
        log.info("Subiendo archivo con nombre de objeto: {} y tipo de contenido: {}", objectName, contentType);
        minioService.uploadFile(file, objectName, contentType);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{objectName}")
    public ResponseEntity<Void> removeFile(@PathVariable String objectName) {
        log.info("Eliminando archivo con nombre de objeto: {}", objectName);
        minioService.removeFile(objectName);
        return ResponseEntity.ok().build();
    }
}
