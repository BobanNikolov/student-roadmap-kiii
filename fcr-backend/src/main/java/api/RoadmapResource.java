package api;

import dao.repository.RoadmapRepository;
import domain.model.RoadmapEntity;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "roadmap")
public interface RoadmapResource extends PanacheRepositoryResource<RoadmapRepository, RoadmapEntity, Long> {
}
