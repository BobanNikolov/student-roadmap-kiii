package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModuleType {
    UNDERGRADUATE("Undergraduate"),
    MASTERS("Masters"),
    POSTGRADUATE("Postgraduate");

    public final String type;

}