package domain.model;

import domain.enums.CourseType;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class CourseEntity {
    @Id
    @Column(name = "course_code")
    private String courseCode;
    @Basic
    @Column(name = "course_ekts")
    private BigInteger courseEkts;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "course_type")
    private CourseType courseType;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "courseByParentCourseOf")
    private Collection<CourseDependencyEntity> courseDependenciesByCourseCode;
    @OneToMany(mappedBy = "courseByChildCourse")
    private Collection<CourseDependencyEntity> courseDependenciesByCourseCode_0;
    @OneToMany(mappedBy = "courseByParentCourse")
    private Collection<CourseDependencyOfEntity> courseDependencyOfsByCourseCode;
    @OneToMany(mappedBy = "courseByChildCourseOf")
    private Collection<CourseDependencyOfEntity> courseDependencyOfsByCourseCode_0;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseInModuleEntity> courseInModulesByCourseCode;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseInRoadmapEntity> courseInRoadmapsByCourseCode;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseStaffEntity> courseStaffsByCourseCode;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<CourseTagEntity> courseTagsByCourseCode;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<SemesterCourseEntity> semesterCoursesByCourseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public BigInteger getCourseEkts() {
        return courseEkts;
    }

    public void setCourseEkts(BigInteger courseEkts) {
        this.courseEkts = courseEkts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (!Objects.equals(courseCode, that.courseCode)) return false;
        if (!Objects.equals(courseEkts, that.courseEkts)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(courseType, that.courseType)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = courseCode != null ? courseCode.hashCode() : 0;
        result = 31 * result + (courseEkts != null ? courseEkts.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (courseType != null ? courseType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<CourseDependencyEntity> getCourseDependenciesByCourseCode() {
        return courseDependenciesByCourseCode;
    }

    public void setCourseDependenciesByCourseCode(Collection<CourseDependencyEntity> courseDependenciesByCourseCode) {
        this.courseDependenciesByCourseCode = courseDependenciesByCourseCode;
    }

    public Collection<CourseDependencyEntity> getCourseDependenciesByCourseCode_0() {
        return courseDependenciesByCourseCode_0;
    }

    public void setCourseDependenciesByCourseCode_0(Collection<CourseDependencyEntity> courseDependenciesByCourseCode_0) {
        this.courseDependenciesByCourseCode_0 = courseDependenciesByCourseCode_0;
    }

    public Collection<CourseDependencyOfEntity> getCourseDependencyOfsByCourseCode() {
        return courseDependencyOfsByCourseCode;
    }

    public void setCourseDependencyOfsByCourseCode(Collection<CourseDependencyOfEntity> courseDependencyOfsByCourseCode) {
        this.courseDependencyOfsByCourseCode = courseDependencyOfsByCourseCode;
    }

    public Collection<CourseDependencyOfEntity> getCourseDependencyOfsByCourseCode_0() {
        return courseDependencyOfsByCourseCode_0;
    }

    public void setCourseDependencyOfsByCourseCode_0(Collection<CourseDependencyOfEntity> courseDependencyOfsByCourseCode_0) {
        this.courseDependencyOfsByCourseCode_0 = courseDependencyOfsByCourseCode_0;
    }

    public Collection<CourseInModuleEntity> getCourseInModulesByCourseCode() {
        return courseInModulesByCourseCode;
    }

    public void setCourseInModulesByCourseCode(Collection<CourseInModuleEntity> courseInModulesByCourseCode) {
        this.courseInModulesByCourseCode = courseInModulesByCourseCode;
    }

    public Collection<CourseInRoadmapEntity> getCourseInRoadmapsByCourseCode() {
        return courseInRoadmapsByCourseCode;
    }

    public void setCourseInRoadmapsByCourseCode(Collection<CourseInRoadmapEntity> courseInRoadmapsByCourseCode) {
        this.courseInRoadmapsByCourseCode = courseInRoadmapsByCourseCode;
    }

    public Collection<CourseStaffEntity> getCourseStaffsByCourseCode() {
        return courseStaffsByCourseCode;
    }

    public void setCourseStaffsByCourseCode(Collection<CourseStaffEntity> courseStaffsByCourseCode) {
        this.courseStaffsByCourseCode = courseStaffsByCourseCode;
    }

    public Collection<CourseTagEntity> getCourseTagsByCourseCode() {
        return courseTagsByCourseCode;
    }

    public void setCourseTagsByCourseCode(Collection<CourseTagEntity> courseTagsByCourseCode) {
        this.courseTagsByCourseCode = courseTagsByCourseCode;
    }

    public Collection<SemesterCourseEntity> getSemesterCoursesByCourseCode() {
        return semesterCoursesByCourseCode;
    }

    public void setSemesterCoursesByCourseCode(Collection<SemesterCourseEntity> semesterCoursesByCourseCode) {
        this.semesterCoursesByCourseCode = semesterCoursesByCourseCode;
    }
}
