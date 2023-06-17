package domain.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedEntityGraph(
        name = "semester-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "semesterForCourse", subgraph = "courseInSemester")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "courseInSemester",
                        attributeNodes = {
                                @NamedAttributeNode(value = "courseByCourseId"),
                        }
                )
        }
)
@Table(name = "semester", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class SemesterEntity extends PanacheEntityBase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "semester_id")
    private long semesterId;
    @Basic
    @Column(name = "semester_number")
    private Integer semesterNumber;
    @Basic
    @Column(name = "semester_year")
    private Integer semesterYear;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "student_index", nullable = false, insertable = false, updatable = false)
    private StudentUserEntity student;
    @Basic
    @Column(name = "date_created")
    private Date dateCreated;
    @OneToMany(mappedBy = "semesterBySemesterId")
    private Collection<SemesterInRoadmapEntity> semesterInRoadmapsBySemesterId;
    @OneToMany(mappedBy = "semesterEntity")
    private Collection<SemesterCourseEntity> semesterForCourse;

    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Integer getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(Integer semesterYear) {
        this.semesterYear = semesterYear;
    }

    public StudentUserEntity getStudent() {
        return student;
    }

    public void setStudentId(StudentUserEntity student) {
        this.student = student;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterEntity that = (SemesterEntity) o;

        if (semesterId != that.semesterId) return false;
        if (!Objects.equals(semesterNumber, that.semesterNumber))
            return false;
        if (!Objects.equals(semesterYear, that.semesterYear)) return false;
        if (!Objects.equals(student, that.student)) return false;
        return Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        int result = (int) (semesterId ^ (semesterId >>> 32));
        result = 31 * result + (semesterNumber != null ? semesterNumber.hashCode() : 0);
        result = 31 * result + (semesterYear != null ? semesterYear.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    public Collection<SemesterInRoadmapEntity> getSemesterInRoadmapsBySemesterId() {
        return semesterInRoadmapsBySemesterId;
    }

    public void setSemesterInRoadmapsBySemesterId(Collection<SemesterInRoadmapEntity> semesterInRoadmapsBySemesterId) {
        this.semesterInRoadmapsBySemesterId = semesterInRoadmapsBySemesterId;
    }
}
