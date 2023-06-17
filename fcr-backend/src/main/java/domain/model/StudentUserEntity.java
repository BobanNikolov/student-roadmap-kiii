package domain.model;

import domain.enums.StudentType;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student_user", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class StudentUserEntity {

    @Id
    @Column(name = "student_index", insertable = false, updatable = false)
    private int studentIndex;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", insertable = false, updatable = false)
    private long userId;
    @Basic
    @Column(name = "student_ekts")
    private BigInteger studentEkts;
    @Basic
    @Column(name = "student_type")
    private StudentType studentType;
    @OneToMany
    @JoinColumn(name = "student", referencedColumnName = "student_index", nullable = false, insertable = false, updatable = false)
    private Collection<SemesterEntity> semestersByStudentIndex;
    @OneToOne
    private RoadmapUserEntity roadmapUserByUserId;

    public int getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(int studentIndex) {
        this.studentIndex = studentIndex;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigInteger getStudentEkts() {
        return studentEkts;
    }

    public void setStudentEkts(BigInteger studentEkts) {
        this.studentEkts = studentEkts;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentUserEntity that = (StudentUserEntity) o;

        if (studentIndex != that.studentIndex) return false;
        if (userId != that.userId) return false;
        if (!Objects.equals(studentEkts, that.studentEkts)) return false;
        return Objects.equals(studentType, that.studentType);
    }

    @Override
    public int hashCode() {
        int result = studentIndex;
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (studentEkts != null ? studentEkts.hashCode() : 0);
        result = 31 * result + (studentType != null ? studentType.hashCode() : 0);
        return result;
    }

    public Collection<SemesterEntity> getSemestersByStudentIndex() {
        return semestersByStudentIndex;
    }

    public void setSemestersByStudentIndex(List<SemesterEntity> semestersByStudentIndex) {
        this.semestersByStudentIndex = semestersByStudentIndex;
    }

    public RoadmapUserEntity getRoadmapUserByUserId() {
        return roadmapUserByUserId;
    }

    public void setRoadmapUserByUserId(RoadmapUserEntity roadmapUserByUserId) {
        this.roadmapUserByUserId = roadmapUserByUserId;
    }
}
