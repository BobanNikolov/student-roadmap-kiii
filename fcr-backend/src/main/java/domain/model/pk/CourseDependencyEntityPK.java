package domain.model.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CourseDependencyEntityPK implements Serializable {
    @Column(name = "parent_course_of")
    @Id
    private String parentCourseOf;
    @Column(name = "child_course")
    @Id
    private String childCourse;

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

        CourseDependencyEntityPK that = (CourseDependencyEntityPK) o;

        if (parentCourseOf != null ? !parentCourseOf.equals(that.parentCourseOf) : that.parentCourseOf != null)
            return false;
        if (childCourse != null ? !childCourse.equals(that.childCourse) : that.childCourse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parentCourseOf != null ? parentCourseOf.hashCode() : 0;
        result = 31 * result + (childCourse != null ? childCourse.hashCode() : 0);
        return result;
    }
}
