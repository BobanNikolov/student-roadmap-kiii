package config.flyway;

import io.quarkus.runtime.StartupEvent;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;


@ApplicationScoped
@NoArgsConstructor
public class FlywayRunner {

    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String datasourceUrl;
    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;
    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;
    @ConfigProperty(name = "quarkus.flyway.schemas")
    String schemas;
    @ConfigProperty(name = "quarkus.flyway.locations")
    String locations;
    @ConfigProperty(name = "quarkus.flyway.table")
    String table;

    public void runFlywayMigration(@Observes StartupEvent event) {
        Flyway flyway = Flyway.configure()
            .dataSource(datasourceUrl, datasourceUsername, datasourcePassword)
            .schemas(schemas)
            .createSchemas(true)
            .locations(locations)
            .table(table)
            .sqlMigrationPrefix("V")
        .load();
        flyway.migrate();
    }


}
