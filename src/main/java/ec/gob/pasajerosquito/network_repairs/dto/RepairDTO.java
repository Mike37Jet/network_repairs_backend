package ec.gob.pasajerosquito.network_repairs.dto;

import lombok.Value;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Value
public class RepairDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    LocalDate repairDate;
    String description;

}
