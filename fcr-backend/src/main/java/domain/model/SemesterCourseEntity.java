package domain.model;

import domain.model.pk.SemesterCourseEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "semester_course", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(SemesterCourseEntityPK.class)
public class SemesterCourseEntity {
    @Id
    @Column(name = "course_id", insertable = false, updatable = false)
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "semester_id", insertable = false, updatable = false)
    private long semesterId;
    @Basic
    @Column(name = "module_id", insertable = false, updatable = false)
    private String moduleId;
    @Basic
    @Column(name = "roadmap_id", insertable = false, updatable = false)
    private long roadmapId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false,  insertable = false, updatable = false),
            @JoinColumn(name = "module_id", referencedColumnName = "module_id", nullable = false,  insertable = false, updatable = false)})
    private CourseInModuleEntity courseInModule;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false,  insertable = false, updatable = false),
            @JoinColumn(name = "roadmap_id", referencedColumnName = "roadmap_id", nullable = false,  insertable = false, updatable = false)})
    private CourseInRoadmapEntity courseInRoadmap;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_code", nullable = false, insertable = false,
            updatable = false)
    private CourseEntity courseByCourseId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "semester_id", referencedColumnName = "semester_id", nullable = false,  insertable = false, updatable = false),
            @JoinColumn(name = "roadmap_id", referencedColumnName = "roadmap_id", nullable = false,  insertable = false, updatable = false)})
    private SemesterInRoadmapEntity semesterInRoadmap;
    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id", nullable = false, insertable = false,
            updatable = false)
    private SemesterEntity semesterEntity;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public long getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(long roadmapId) {
        this.roadmapId = roadmapId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterCourseEntity that = (SemesterCourseEntity) o;

        if (semesterId != that.semesterId) return false;
        if (roadmapId != that.roadmapId) return false;
        if (!Objects.equals(courseId, that.courseId)) return false;
        return Objects.equals(moduleId, that.moduleId);
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (int) (semesterId ^ (semesterId >>> 32));
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        result = 31 * result + (int) (roadmapId ^ (roadmapId >>> 32));
        return result;
    }

    public CourseInModuleEntity getCourseInModule() {
        return courseInModule;
    }

    public void setCourseInModule(CourseInModuleEntity courseInModule) {
        this.courseInModule = courseInModule;
    }

    public CourseInRoadmapEntity getCourseInRoadmap() {
        return courseInRoadmap;
    }

    public void setCourseInRoadmap(CourseInRoadmapEntity courseInRoadmap) {
        this.courseInRoadmap = courseInRoadmap;
    }

    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public SemesterInRoadmapEntity getSemesterInRoadmap() {
        return semesterInRoadmap;
    }

    public void setSemesterInRoadmap(SemesterInRoadmapEntity semesterInRoadmap) {
        this.semesterInRoadmap = semesterInRoadmap;
    }
}
