package domain.model;

import javax.persistence.*;

@Entity
@Table(name = "admin_user", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class AdminUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private long userId;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private RoadmapUserEntity roadmapUserByUserId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminUserEntity that = (AdminUserEntity) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (userId ^ (userId >>> 32));
    }

    public RoadmapUserEntity getRoadmapUserByUserId() {
        return roadmapUserByUserId;
    }

    public void setRoadmapUserByUserId(RoadmapUserEntity roadmapUserByUserId) {
        this.roadmapUserByUserId = roadmapUserByUserId;
    }
}
