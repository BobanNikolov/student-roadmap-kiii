package dao.repository;

import domain.model.RoadmapEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoadmapRepository implements PanacheRepository<RoadmapEntity> {
}
