package domain.model.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class SemesterCourseEntityPK implements Serializable {
    @Column(name = "course_id")
    @Id
    private String courseId;
    @Column(name = "semester_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long semesterId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterCourseEntityPK that = (SemesterCourseEntityPK) o;

        if (semesterId != that.semesterId) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (int) (semesterId ^ (semesterId >>> 32));
        return result;
    }
}
