package ec.gob.pasajerosquito.network_repairs.services;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {

    String getPreSignedObjectUrl(String objectName);

    boolean uploadImage(MultipartFile file, String objectName);

    void removeFile(String objectName);

    void uploadFile(MultipartFile file, String objectName, String contentType);
}
