package domain.model.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CourseInRoadmapEntityPK implements Serializable {
    @Column(name = "course_id")
    @Id
    private String courseId;
    @Column(name = "roadmap_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roadmapId;

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

        CourseInRoadmapEntityPK that = (CourseInRoadmapEntityPK) o;

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
}
