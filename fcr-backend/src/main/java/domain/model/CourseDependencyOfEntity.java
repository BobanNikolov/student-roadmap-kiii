package domain.model;

import domain.model.pk.CourseDependencyOfEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_dependency_of", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseDependencyOfEntityPK.class)
public class CourseDependencyOfEntity {
    @Id
    @Column(name = "parent_course")
    private String parentCourse;
    @Id
    @Column(name = "child_course_of",  insertable = false, updatable = false)
    private String childCourseOf;
    @ManyToOne
    @JoinColumn(name = "parent_course", referencedColumnName = "course_code", nullable = false,  insertable = false, updatable = false)
    private CourseEntity courseByParentCourse;
    @ManyToOne
    @JoinColumn(name = "child_course_of", referencedColumnName = "course_code", nullable = false,  insertable = false, updatable = false)
    private CourseEntity courseByChildCourseOf;

    public String getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(String parentCourse) {
        this.parentCourse = parentCourse;
    }

    public String getChildCourseOf() {
        return childCourseOf;
    }

    public void setChildCourseOf(String childCourseOf) {
        this.childCourseOf = childCourseOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDependencyOfEntity that = (CourseDependencyOfEntity) o;

        if (!Objects.equals(parentCourse, that.parentCourse)) return false;
        return Objects.equals(childCourseOf, that.childCourseOf);
    }

    @Override
    public int hashCode() {
        int result = parentCourse != null ? parentCourse.hashCode() : 0;
        result = 31 * result + (childCourseOf != null ? childCourseOf.hashCode() : 0);
        return result;
    }

    public CourseEntity getCourseByParentCourse() {
        return courseByParentCourse;
    }

    public void setCourseByParentCourse(CourseEntity courseByParentCourse) {
        this.courseByParentCourse = courseByParentCourse;
    }

    public CourseEntity getCourseByChildCourseOf() {
        return courseByChildCourseOf;
    }

    public void setCourseByChildCourseOf(CourseEntity courseByChildCourseOf) {
        this.courseByChildCourseOf = courseByChildCourseOf;
    }
}
