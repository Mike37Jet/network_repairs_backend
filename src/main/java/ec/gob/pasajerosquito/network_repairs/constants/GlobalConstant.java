package ec.gob.pasajerosquito.network_repairs.constants;

public final class GlobalConstant {
    public static final String API = "/api";
    public static final String API_VERSION = "/v1";
    public static final String API_URL = API + API_VERSION;
    public static final String REPAIR_PATH = API_URL + "/repairs";
    public static final String MINIO_PATH = API_URL + "/minio";
    public static final String IMAGE_AFTER_REPAIR_PATH = API_URL + "/images-after-repair";
    public static final String IMAGE_BEFORE_REPAIR_PATH = API_URL + "/images-before-repair";

    private GlobalConstant() {
    }
}
