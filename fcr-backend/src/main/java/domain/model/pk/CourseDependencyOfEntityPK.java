package domain.model.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CourseDependencyOfEntityPK implements Serializable {
    @Column(name = "parent_course")
    @Id
    private String parentCourse;
    @Column(name = "child_course_of")
    @Id
    private String childCourseOf;

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

        CourseDependencyOfEntityPK that = (CourseDependencyOfEntityPK) o;

        if (parentCourse != null ? !parentCourse.equals(that.parentCourse) : that.parentCourse != null) return false;
        if (childCourseOf != null ? !childCourseOf.equals(that.childCourseOf) : that.childCourseOf != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parentCourse != null ? parentCourse.hashCode() : 0;
        result = 31 * result + (childCourseOf != null ? childCourseOf.hashCode() : 0);
        return result;
    }
}
