package api;

import dao.repository.CourseRepository;
import domain.model.CourseEntity;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "course")
public interface CourseResource extends PanacheRepositoryResource<CourseRepository, CourseEntity, String> {
}
