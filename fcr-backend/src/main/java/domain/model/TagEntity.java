package domain.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tag", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class TagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "tag_text")
    private String tagText;
    @OneToMany(mappedBy = "tagByTagId")
    private Collection<CourseTagEntity> courseTagsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagEntity tagEntity = (TagEntity) o;

        if (id != tagEntity.id) return false;
        return Objects.equals(tagText, tagEntity.tagText);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tagText != null ? tagText.hashCode() : 0);
        return result;
    }

    public Collection<CourseTagEntity> getCourseTagsById() {
        return courseTagsById;
    }

    public void setCourseTagsById(Collection<CourseTagEntity> courseTagsById) {
        this.courseTagsById = courseTagsById;
    }
}
