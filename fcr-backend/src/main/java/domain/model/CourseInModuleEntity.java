package domain.model;

import domain.enums.CourseAvailability;
import domain.model.pk.CourseInModuleEntityPK;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course_in_module", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseInModuleEntityPK.class)
public class CourseInModuleEntity {
    @Id
    @Column(name = "course_id", insertable = false, updatable = false)
    private String courseId;
    @Id
    @Column(name = "module_id", insertable = false, updatable = false)
    private String moduleId;
    @Basic
    @Column(name = "semester_available")
    private CourseAvailability semesterAvailable;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_code", nullable = false,
            insertable = false, updatable = false)
    private CourseEntity courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "abbreviation", nullable = false,
            insertable = false, updatable = false)
    private ModuleEntity moduleByModuleId;
    @OneToMany(mappedBy = "courseInModule")
    private Collection<SemesterCourseEntity> semesterCourses;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public CourseAvailability getSemesterAvailable() {
        return semesterAvailable;
    }

    public void setSemesterAvailable(CourseAvailability semesterAvailable) {
        this.semesterAvailable = semesterAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInModuleEntity that = (CourseInModuleEntity) o;

        if (!Objects.equals(courseId, that.courseId)) return false;
        if (!Objects.equals(moduleId, that.moduleId)) return false;
        return Objects.equals(semesterAvailable, that.semesterAvailable);
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (moduleId != null ? moduleId.hashCode() : 0);
        result = 31 * result + (semesterAvailable != null ? semesterAvailable.hashCode() : 0);
        return result;
    }

    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public ModuleEntity getModuleByModuleId() {
        return moduleByModuleId;
    }

    public void setModuleByModuleId(ModuleEntity moduleByModuleId) {
        this.moduleByModuleId = moduleByModuleId;
    }

    public Collection<SemesterCourseEntity> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Collection<SemesterCourseEntity> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }
}
