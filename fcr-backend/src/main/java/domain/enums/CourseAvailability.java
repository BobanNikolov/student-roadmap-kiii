package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseAvailability {

    I_SEMESTER("First Semester"),
    II_SEMESTER("Second Semester"),
    III_SEMESTER("Third Semester"),
    IV_SEMESTER("Fourth Semester"),
    V_SEMESTER("Fifth Semester"),
    VI_SEMESTER("Sixth Semester"),
    VII_SEMESTER("Seventh Semester"),
    VIII_SEMESTER("Eighth Semester");

    public final String semester;
}
