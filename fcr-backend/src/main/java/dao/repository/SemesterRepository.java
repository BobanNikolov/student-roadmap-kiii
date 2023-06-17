package dao.repository;

import domain.model.SemesterEntity;
import domain.model.SemesterInRoadmapEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class SemesterRepository implements PanacheRepository<SemesterEntity> {

    public Uni<List<SemesterEntity>> findSemestersForStudent(int studentIndex) {
      return find("student = :student_index", Collections.singletonMap("student_index", studentIndex)).list();
    }
}
