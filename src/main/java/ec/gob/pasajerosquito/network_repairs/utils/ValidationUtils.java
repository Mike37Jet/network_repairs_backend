package ec.gob.pasajerosquito.network_repairs.utils;

import ec.gob.pasajerosquito.network_repairs.exceptions.NetworkRepairsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

@Slf4j
public final class ValidationUtils {
    private ValidationUtils() {
    }

    public static void validateId(Long id, String entity, String name) {
        if (!ObjectUtils.isEmpty(id) && id > 0) return;
        log.error("Field id is required to update {}", entity);
        throw new NetworkRepairsException("Error al actualizar: " + name + ", verifique los campos requeridos");
    }
}
