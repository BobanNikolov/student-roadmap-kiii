package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseType {
    MANDATORY("Mandatory"),
    ELECTIVE("Elective");
    public final String type;

}