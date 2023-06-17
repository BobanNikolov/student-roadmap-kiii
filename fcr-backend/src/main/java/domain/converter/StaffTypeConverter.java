package domain.converter;

import domain.enums.ModuleType;
import domain.enums.StaffType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StaffTypeConverter implements AttributeConverter<StaffType, String> {

    @Override
    public String convertToDatabaseColumn(StaffType staffType) {
        return switch (staffType) {
            case ADMINISTRATIVE -> StaffType.ADMINISTRATIVE.getType();
            case ASSISTANT -> StaffType.ASSISTANT.getType();
            case PROFESSOR -> StaffType.PROFESSOR.getType();
        };
    }

    @Override
    public StaffType convertToEntityAttribute(String s) {
        return switch (s) {
            case "Administrative" -> StaffType.ADMINISTRATIVE;
            case "Assistant" -> StaffType.ASSISTANT;
            case "Professor" -> StaffType.PROFESSOR;
            default -> throw new IllegalArgumentException("Provided Invalid values for staff type.");
        };
    }

}
