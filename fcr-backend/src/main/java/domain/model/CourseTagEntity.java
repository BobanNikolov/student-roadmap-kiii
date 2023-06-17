package domain.model;

import domain.model.pk.CourseTagEntityPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_tag", schema = "course_roadmap_db", catalog = "course_roadmap_db")
@IdClass(CourseTagEntityPK.class)
public class CourseTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id",  insertable = false, updatable = false)
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tag_id",  insertable = false, updatable = false)
    private long tagId;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_code", nullable = false,  insertable = false,
            updatable = false)
    private CourseEntity courseByCourseId;
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false,  insertable = false, updatable = false)
    private TagEntity tagByTagId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseTagEntity that = (CourseTagEntity) o;

        if (tagId != that.tagId) return false;
        return Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (int) (tagId ^ (tagId >>> 32));
        return result;
    }

    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public TagEntity getTagByTagId() {
        return tagByTagId;
    }

    public void setTagByTagId(TagEntity tagByTagId) {
        this.tagByTagId = tagByTagId;
    }
}
