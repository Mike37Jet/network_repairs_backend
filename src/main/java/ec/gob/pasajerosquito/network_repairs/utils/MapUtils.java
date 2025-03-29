package ec.gob.pasajerosquito.network_repairs.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MapUtils {
    private MapUtils() {
    }

    public static Map<String, Object> getMapFromProperties(Properties properties) {
        Map<String, Object> propertiesMap = new HashMap<>();
        properties.forEach((key, value) -> propertiesMap.put((String) key, value));
        return propertiesMap;
    }
}
