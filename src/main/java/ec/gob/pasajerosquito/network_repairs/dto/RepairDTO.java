package ec.gob.pasajerosquito.network_repairs.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class RepairDTO implements Serializable {

    Long id;
    LocalDate repairDate;
    String description;

}
