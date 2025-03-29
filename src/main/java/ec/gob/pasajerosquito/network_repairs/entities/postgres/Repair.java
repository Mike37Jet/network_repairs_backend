package ec.gob.pasajerosquito.network_repairs.entities.postgres;

import ec.gob.pasajerosquito.network_repairs.entities.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Repair extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "repair_date")
    private LocalDate repairDate;
    private String description;

    //Este metodo es una sobrescritura del metodo equals de la clase Object en Java.
    //Se utiliza para comparar dos objetos de la clase Repair y determinar si son iguales.
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Repair repair = (Repair) object;
        return Objects.equals(id, repair.id);
    }

    //Este metodo es una sobrescritura del metodo hashCode de la clase Object en Java.
    //Se utiliza para generar un valor hash unico para el objeto Repair.
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
