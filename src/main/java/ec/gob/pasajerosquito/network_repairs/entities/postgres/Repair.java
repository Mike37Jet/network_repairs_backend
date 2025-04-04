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
@Table(name = "repairs")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Repair extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5665468053129322675L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "repair_date")
    private LocalDate repairDate;
    private String description;

    /*
     * Este metodo es una sobrescritura del metodo equals de la clase Object en
     * Java.
     * Se utiliza para comparar dos objetos Repair y determinar si son iguales.
     * En este caso, se comparan los atributos id de ambos objetos.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Repair repair = (Repair) object;
        return Objects.equals(id, repair.id);
    }

    /*
     * Este metodo es una sobrescritura del metodo hashCode de la clase Object en
     * Java.
     * Se utiliza para generar un valor hash para el objeto Repair.
     * En este caso, se utiliza el atributo id para generar el valor hash.
     * Esto es importante para el correcto funcionamiento de las colecciones que
     * utilizan hashing, como HashMap o HashSet.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
