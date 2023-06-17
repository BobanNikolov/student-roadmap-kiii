package api;

import dao.repository.SemesterRepository;
import domain.model.SemesterEntity;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.smallrye.mutiny.Uni;

import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;


@ResourceProperties(path = "semester")
public interface SemesterResource extends PanacheRepositoryResource<SemesterRepository, SemesterEntity, Long> {

    @GET
    @Path("/student/{student_index}")
    @Produces("application/json")
    default Uni<List<SemesterEntity>> getSemestersForUser(@PathParam("student_index") int studentIndex) {
        return CDI.current().select(SemesterRepository.class).get().findSemestersForStudent(studentIndex);
    }

}
