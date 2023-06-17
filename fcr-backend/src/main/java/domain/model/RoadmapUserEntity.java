package domain.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roadmap_user", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class RoadmapUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToOne(mappedBy = "roadmapUserByUserId")
    private AdminUserEntity adminUserById;
    @OneToOne(mappedBy = "roadmapUserByStaffId")
    private StaffUserEntity staffUserById;
    @OneToOne(mappedBy = "roadmapUserByUserId")
    private StudentUserEntity studentUsersById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadmapUserEntity that = (RoadmapUserEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public AdminUserEntity getAdminUserById() {
        return adminUserById;
    }

    public void setAdminUserById(AdminUserEntity adminUserById) {
        this.adminUserById = adminUserById;
    }

    public StaffUserEntity getStaffUserById() {
        return staffUserById;
    }

    public void setStaffUserById(StaffUserEntity staffUserById) {
        this.staffUserById = staffUserById;
    }

    public StudentUserEntity getStudentUsersById() {
        return studentUsersById;
    }

    public void setStudentUsersById(StudentUserEntity studentUsersById) {
        this.studentUsersById = studentUsersById;
    }
}
