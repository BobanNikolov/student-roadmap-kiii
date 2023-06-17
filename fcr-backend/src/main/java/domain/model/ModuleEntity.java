package domain.model;

import domain.enums.ModuleType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "module", schema = "course_roadmap_db", catalog = "course_roadmap_db")
public class ModuleEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "abbreviation")
    private String abbreviation;
    @Basic
    @Column(name = "module_type")
    private ModuleType moduleType;
    @Basic
    @Column(name = "module_length")
    private Integer moduleLength;
    @OneToMany(mappedBy = "moduleByModuleId")
    private Collection<CourseInModuleEntity> courseInModulesByAbbreviation;
    @OneToMany(mappedBy = "moduleByModuleId")
    private Collection<RoadmapEntity> roadmapsByAbbreviation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public Integer getModuleLength() {
        return moduleLength;
    }

    public void setModuleLength(Integer moduleLength) {
        this.moduleLength = moduleLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleEntity that = (ModuleEntity) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(abbreviation, that.abbreviation)) return false;
        if (!Objects.equals(moduleType, that.moduleType)) return false;
        return Objects.equals(moduleLength, that.moduleLength);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (moduleType != null ? moduleType.hashCode() : 0);
        result = 31 * result + (moduleLength != null ? moduleLength.hashCode() : 0);
        return result;
    }

    public Collection<CourseInModuleEntity> getCourseInModulesByAbbreviation() {
        return courseInModulesByAbbreviation;
    }

    public void setCourseInModulesByAbbreviation(Collection<CourseInModuleEntity> courseInModulesByAbbreviation) {
        this.courseInModulesByAbbreviation = courseInModulesByAbbreviation;
    }

    public Collection<RoadmapEntity> getRoadmapsByAbbreviation() {
        return roadmapsByAbbreviation;
    }

    public void setRoadmapsByAbbreviation(Collection<RoadmapEntity> roadmapsByAbbreviation) {
        this.roadmapsByAbbreviation = roadmapsByAbbreviation;
    }
}
