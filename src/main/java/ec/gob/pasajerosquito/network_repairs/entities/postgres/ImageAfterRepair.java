package ec.gob.pasajerosquito.network_repairs.entities.postgres;

import ec.gob.pasajerosquito.network_repairs.entities.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "repair_images_after")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageAfterRepair extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "repair_id")
    private Long repairId;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "taken_at")
    private LocalDate takenAt;

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        ImageAfterRepair imageAfterRepair = (ImageAfterRepair) object;
        return Objects.equals(id, imageAfterRepair.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
