package dao.repository;


import domain.model.CourseEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<CourseEntity, String> {
}
