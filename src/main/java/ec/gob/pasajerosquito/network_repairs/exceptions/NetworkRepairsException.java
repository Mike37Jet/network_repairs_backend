package ec.gob.pasajerosquito.network_repairs.exceptions;
import java.io.Serial;
public class NetworkRepairsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1376275143045079483L;

    public NetworkRepairsException(String message) {
        super(message);
    }

    public NetworkRepairsException(String message, Throwable cause) {
        super(message, cause);
    }
}
