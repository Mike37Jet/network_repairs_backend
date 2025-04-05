package ec.gob.pasajerosquito.network_repairs.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class ImageAfterRepairDTO implements Serializable {
    Long id;
    Long repairId;
    String imageUrl;
    LocalDate takenAt;
}
