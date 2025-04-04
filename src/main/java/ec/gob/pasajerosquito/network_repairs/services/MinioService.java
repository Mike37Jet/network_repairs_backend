package ec.gob.pasajerosquito.network_repairs.services;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {

    String getPreSignedObjectUrl(String objectName);

    String uploadImage(MultipartFile file, String repairId, String objectName);

    void removeFile(String objectName);

}
