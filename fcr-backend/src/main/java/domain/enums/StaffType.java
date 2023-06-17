package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StaffType {
    ADMINISTRATIVE("Administrative"),
    PROFESSOR("Professor"),
    ASSISTANT("Assistant");

    public final String type;

}