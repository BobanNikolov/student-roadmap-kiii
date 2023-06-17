package domain.model;

import domain.model.pk.CourseInRoadmapEntityPK;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "course_in_roadmap", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseInRoadmapEntityPK.class)
public class CourseInRoadmapEntity {
    @Id
    @Column(name = "course_id",  insertable = false, updatable = false)
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roadmap_id", insertable = false, updatable = false)
    private long roadmapId;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_code", nullable = false, insertable = false,
            updatable = false)
    private CourseEntity courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "roadmap_id", referencedColumnName = "roadmap_id", nullable = false, insertable = false,
            updatable = false)
    private RoadmapEntity roadmapByRoadmapId;
    @OneToMany(mappedBy = "courseInRoadmap")
    private Collection<SemesterCourseEntity> semesterCourses;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

        CourseInRoadmapEntity that = (CourseInRoadmapEntity) o;

        if (roadmapId != that.roadmapId) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (int) (roadmapId ^ (roadmapId >>> 32));
        return result;
    }

    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public RoadmapEntity getRoadmapByRoadmapId() {
        return roadmapByRoadmapId;
    }

    public void setRoadmapByRoadmapId(RoadmapEntity roadmapByRoadmapId) {
        this.roadmapByRoadmapId = roadmapByRoadmapId;
    }

    public Collection<SemesterCourseEntity> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Collection<SemesterCourseEntity> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }
}
