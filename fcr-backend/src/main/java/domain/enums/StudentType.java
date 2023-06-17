package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentType {
    UNDERGRADUATE("Undergraduate"),
    MASTERS("Masters"),
    POSTGRADUATE("Postgraduate");

    public final String type;

}