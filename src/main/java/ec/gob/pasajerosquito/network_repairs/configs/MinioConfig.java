package ec.gob.pasajerosquito.network_repairs.configs;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${app.minio.url}")
    private String url;

    @Value("${app.minio.accessKey}")
    private String accessKey;

    @Value("${app.minio.secretKey}")
    private String secretKey;

    @Value("${app.minio.region}")
    private String region;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).region(region).build();
    }
}
