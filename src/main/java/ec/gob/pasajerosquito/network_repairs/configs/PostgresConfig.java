package ec.gob.pasajerosquito.maintenance_tracker.configs;

import ec.gob.pasajerosquito.maintenance_tracker.utils.MapUtils;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"ec.gob.pasajerosquito.maintenance_tracker.repositories.postgres"},
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.postgresql-db")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa.postgres")
    public Properties postgresHibernateProperties() {
        return new Properties();
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresDataSource") DataSource postgresDataSource,
            @Qualifier("postgresHibernateProperties") Properties hibernateProperties) {
        return builder
                .dataSource(postgresDataSource)
                .packages("ec.gob.pasajerosquito.maintenance_tracker.entities.postgres")
                .persistenceUnit("postgres")
                .properties(MapUtils.getMapFromProperties(hibernateProperties))
                .build();
    }

    @Bean
    PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
        return new JpaTransactionManager(postgresEntityManagerFactory);
    }
}
