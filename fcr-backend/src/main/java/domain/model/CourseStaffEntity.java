package domain.model;

import domain.model.pk.CourseStaffEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_staff", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseStaffEntityPK.class)
public class CourseStaffEntity {
    @Id
    @Column(name = "course_id",  insertable = false, updatable = false)
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id",  insertable = false, updatable = false)
    private long staffId;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_code", nullable = false,
            insertable = false, updatable = false)
    private CourseEntity courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false,
            insertable = false, updatable = false)
    private StaffUserEntity staffUserByStaffId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseStaffEntity that = (CourseStaffEntity) o;

        if (staffId != that.staffId) return false;
        return Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (int) (staffId ^ (staffId >>> 32));
        return result;
    }

    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public StaffUserEntity getStaffUserByStaffId() {
        return staffUserByStaffId;
    }

    public void setStaffUserByStaffId(StaffUserEntity staffUserByStaffId) {
        this.staffUserByStaffId = staffUserByStaffId;
    }
}
