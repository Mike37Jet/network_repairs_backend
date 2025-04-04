package ec.gob.pasajerosquito.network_repairs.services.implementers;

import ec.gob.pasajerosquito.network_repairs.constants.MinioConstant;
import ec.gob.pasajerosquito.network_repairs.exceptions.MinioException;
import ec.gob.pasajerosquito.network_repairs.services.MinioService;
import io.minio.MinioClient;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.PutObjectArgs;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.RemoveObjectArgs;
import io.minio.http.Method;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;

    @Value("${app.minio.bucketName}")
    private String bucketName;

    @PostConstruct
    public void init() {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                log.warn("Bucket '{}' no existe, creándolo...", bucketName);
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } else {
                log.info("Bucket '{}' ya existe", bucketName);
            }
        } catch (Exception e) {
            throw new MinioException("Error al crear el bucket de Minio: " + bucketName, e);
        }
    }

    @Override
    public String getPreSignedObjectUrl(String objectName) {
        try {
            // Verificar si el objeto existe
            minioClient.statObject(
                    io.minio.StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
            // Si existe, se genera la URL pre-firmada
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .method(Method.GET)
                            .expiry(MinioConstant.PRE_SIGNED_URL_EXPIRE_TIME)
                            .build());
        } catch (Exception e) {
            log.error("El objeto '{}' no existe o error al obtener información: {}", objectName, e.getMessage());
            throw new MinioException("El objeto no existe: " + objectName, e);
        }
    }

    @Override
    public boolean uploadImage(MultipartFile file, String objectName) {
        try {
            var contentType = file.getContentType();
            if (!StringUtils.hasText(contentType) || !contentType.startsWith("image/")) {
                log.error("Tipo de imagen inválido: {}", contentType);
                return false;
            }
            uploadFile(file, objectName, contentType);
            return true;
        } catch (Exception e) {
            log.error("Error al subir el archivo: {}", objectName, e);
            return false;
        }
    }

    @Override
    public void removeFile(String objectName) {
        try {
            // Intentar obtener la metadata del objeto
            var stat = minioClient.statObject(
                    io.minio.StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
            if (stat == null) {
                // Si no se obtuvo información, asumimos que no existe y lanzamos error
                throw new MinioException("El objeto no existe: " + objectName, null);
            }
        } catch (Exception e) {
            // O si ocurre error (según la excepción que retorne Minio en este caso),
            // lanzamos error
            log.error("El objeto '{}' no existe, no se elimina", objectName);
            throw new MinioException("El objeto no existe: " + objectName, e);
        }

        try {
            // Procede a eliminar el objeto
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build());
            log.info("Objeto '{}' eliminado correctamente", objectName);
        } catch (Exception e) {
            log.error("Error eliminando el objeto '{}': {}", objectName, e.getMessage());
            throw new MinioException("Error eliminando el objeto: " + objectName, e);
        }
    }

    @Override
    public void uploadFile(MultipartFile file, String objectName, String contentType) {
        try {
            var inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .contentType(contentType)
                    .stream(inputStream, inputStream.available(), -1)
                    .build());
        } catch (Exception e) {
            throw new MinioException("Error al subir el archivo: " + objectName, e);
        }
    }
}
