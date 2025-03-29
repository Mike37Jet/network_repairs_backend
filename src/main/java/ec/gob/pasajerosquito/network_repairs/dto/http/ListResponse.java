package ec.gob.pasajerosquito.network_repairs.dto.http;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ListResponse<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7480880153099174050L;

    private List<T> data;

    public ListResponse(List<T> data) {
        this.data = data;
    }
}
