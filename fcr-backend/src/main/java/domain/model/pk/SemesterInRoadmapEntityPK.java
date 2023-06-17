package domain.model.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class SemesterInRoadmapEntityPK implements Serializable {
    @Column(name = "semester_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterId;
    @Column(name = "roadmap_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roadmapId;

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

        SemesterInRoadmapEntityPK that = (SemesterInRoadmapEntityPK) o;

        if (semesterId != that.semesterId) return false;
        if (roadmapId != that.roadmapId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semesterId;
        result = 31 * result + (int) (roadmapId ^ (roadmapId >>> 32));
        return result;
    }
}
