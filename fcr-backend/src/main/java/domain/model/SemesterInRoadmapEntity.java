package domain.model;

import domain.model.pk.SemesterInRoadmapEntityPK;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semester_in_roadmap", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(SemesterInRoadmapEntityPK.class)
public class SemesterInRoadmapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "semester_id",  insertable = false, updatable = false)
    private int semesterId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roadmap_id",  insertable = false, updatable = false)
    private long roadmapId;
    @OneToMany(mappedBy = "semesterInRoadmap")
    private Collection<SemesterCourseEntity> semesterCourses;
    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id", nullable = false, insertable = false,
            updatable = false)
    private SemesterEntity semesterBySemesterId;
    @ManyToOne
    @JoinColumn(name = "roadmap_id", referencedColumnName = "roadmap_id", nullable = false,  insertable = false,
            updatable = false)
    private RoadmapEntity roadmapByRoadmapId;

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public long getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(long roadmapId) {
        this.roadmapId = roadmapId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterInRoadmapEntity that = (SemesterInRoadmapEntity) o;

        if (semesterId != that.semesterId) return false;
        return roadmapId == that.roadmapId;
    }

    @Override
    public int hashCode() {
        int result = semesterId;
        result = 31 * result + (int) (roadmapId ^ (roadmapId >>> 32));
        return result;
    }

    public Collection<SemesterCourseEntity> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Collection<SemesterCourseEntity> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    public SemesterEntity getSemesterBySemesterId() {
        return semesterBySemesterId;
    }

    public void setSemesterBySemesterId(SemesterEntity semesterBySemesterId) {
        this.semesterBySemesterId = semesterBySemesterId;
    }

    public RoadmapEntity getRoadmapByRoadmapId() {
        return roadmapByRoadmapId;
    }

    public void setRoadmapByRoadmapId(RoadmapEntity roadmapByRoadmapId) {
        this.roadmapByRoadmapId = roadmapByRoadmapId;
    }
}
