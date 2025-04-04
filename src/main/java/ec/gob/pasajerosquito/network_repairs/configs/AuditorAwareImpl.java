package ec.gob.pasajerosquito.network_repairs.configs;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        //TODO replace this with authenticated user
        return Optional.of("pasajerosquito");
    }
}
