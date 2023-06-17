package domain.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roadmap", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class RoadmapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roadmap_id")
    private long roadmapId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "module_id",  insertable = false, updatable = false)
    private String moduleId;
    @OneToMany(mappedBy = "roadmapByRoadmapId")
    private Collection<CourseInRoadmapEntity> courseInRoadmapsByRoadmapId;
    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "abbreviation",  insertable = false, updatable = false)
    private ModuleEntity moduleByModuleId;
    @OneToMany(mappedBy = "roadmapByRoadmapId")
    private Collection<SemesterInRoadmapEntity> semesterInRoadmapsByRoadmapId;

    public long getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(long roadmapId) {
        this.roadmapId = roadmapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadmapEntity that = (RoadmapEntity) o;

        if (roadmapId != that.roadmapId) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(moduleId, that.moduleId);
    }

    @Override
    public int hashCode() {
        int result = (int) (roadmapId ^ (roadmapId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        return result;
    }

    public Collection<CourseInRoadmapEntity> getCourseInRoadmapsByRoadmapId() {
        return courseInRoadmapsByRoadmapId;
    }

    public void setCourseInRoadmapsByRoadmapId(Collection<CourseInRoadmapEntity> courseInRoadmapsByRoadmapId) {
        this.courseInRoadmapsByRoadmapId = courseInRoadmapsByRoadmapId;
    }

    public ModuleEntity getModuleByModuleId() {
        return moduleByModuleId;
    }

    public void setModuleByModuleId(ModuleEntity moduleByModuleId) {
        this.moduleByModuleId = moduleByModuleId;
    }

    public Collection<SemesterInRoadmapEntity> getSemesterInRoadmapsByRoadmapId() {
        return semesterInRoadmapsByRoadmapId;
    }

    public void setSemesterInRoadmapsByRoadmapId(Collection<SemesterInRoadmapEntity> semesterInRoadmapsByRoadmapId) {
        this.semesterInRoadmapsByRoadmapId = semesterInRoadmapsByRoadmapId;
    }
}
