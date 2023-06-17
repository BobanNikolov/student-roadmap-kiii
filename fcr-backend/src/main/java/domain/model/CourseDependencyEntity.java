package domain.model;

import domain.model.pk.CourseDependencyEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_dependency", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseDependencyEntityPK.class)
public class CourseDependencyEntity {
    @Id
    @Column(name = "parent_course_of", insertable = false, updatable = false)
    private String parentCourseOf;
    @Id
    @Column(name = "child_course", insertable = false, updatable = false)
    private String childCourse;
    @ManyToOne
    @JoinColumn(name = "parent_course_of", referencedColumnName = "course_code", nullable = false,
            insertable = false, updatable = false)
    private CourseEntity courseByParentCourseOf;
    @ManyToOne
    @JoinColumn(name = "child_course", referencedColumnName = "course_code", nullable = false,
    insertable = false, updatable = false)
    private CourseEntity courseByChildCourse;

    public String getParentCourseOf() {
        return parentCourseOf;
    }

    public void setParentCourseOf(String parentCourseOf) {
        this.parentCourseOf = parentCourseOf;
    }

    public String getChildCourse() {
        return childCourse;
    }

    public void setChildCourse(String childCourse) {
        this.childCourse = childCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDependencyEntity that = (CourseDependencyEntity) o;

        if (!Objects.equals(parentCourseOf, that.parentCourseOf))
            return false;
        return Objects.equals(childCourse, that.childCourse);
    }

    @Override
    public int hashCode() {
        int result = parentCourseOf != null ? parentCourseOf.hashCode() : 0;
        result = 31 * result + (childCourse != null ? childCourse.hashCode() : 0);
        return result;
    }

    public CourseEntity getCourseByParentCourseOf() {
        return courseByParentCourseOf;
    }

    public void setCourseByParentCourseOf(CourseEntity courseByParentCourseOf) {
        this.courseByParentCourseOf = courseByParentCourseOf;
    }

    public CourseEntity getCourseByChildCourse() {
        return courseByChildCourse;
    }

    public void setCourseByChildCourse(CourseEntity courseByChildCourse) {
        this.courseByChildCourse = courseByChildCourse;
    }
}
