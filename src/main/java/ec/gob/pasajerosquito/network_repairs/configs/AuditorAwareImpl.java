package ec.gob.pasajerosquito.maintenance_tracker.configs;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    @SuppressWarnings("NullableProblems")
    public Optional<String> getCurrentAuditor() {
        // TODO replace this with authenticated user
        return Optional.of("pasajerosquito");
    }
}
