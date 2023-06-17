package domain.model;

import domain.enums.StaffType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "staff_user", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class StaffUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id",  insertable = false, updatable = false)
    private long staffId;
    @Basic
    @Column(name = "staff_type")
    private StaffType staffType;
    @OneToMany(mappedBy = "staffUserByStaffId")
    private Collection<CourseStaffEntity> courseStaffsByStaffId;
    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false,  insertable = false, updatable = false)
    private RoadmapUserEntity roadmapUserByStaffId;

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffUserEntity that = (StaffUserEntity) o;

        if (staffId != that.staffId) return false;
        return Objects.equals(staffType, that.staffType);
    }

    @Override
    public int hashCode() {
        int result = (int) (staffId ^ (staffId >>> 32));
        result = 31 * result + (staffType != null ? staffType.hashCode() : 0);
        return result;
    }

    public Collection<CourseStaffEntity> getCourseStaffsByStaffId() {
        return courseStaffsByStaffId;
    }

    public void setCourseStaffsByStaffId(Collection<CourseStaffEntity> courseStaffsByStaffId) {
        this.courseStaffsByStaffId = courseStaffsByStaffId;
    }

    public RoadmapUserEntity getRoadmapUserByStaffId() {
        return roadmapUserByStaffId;
    }

    public void setRoadmapUserByStaffId(RoadmapUserEntity roadmapUserByStaffId) {
        this.roadmapUserByStaffId = roadmapUserByStaffId;
    }
}
