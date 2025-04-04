package ec.gob.pasajerosquito.network_repairs.exceptions;

import java.io.Serial;

public class MinioException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5791460604031773316L;

    public MinioException(String message, Throwable cause) {
        super(message, cause);
    }
}
