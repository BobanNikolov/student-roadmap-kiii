package domain.converter;

import domain.enums.CourseType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CourseTypeConverter implements AttributeConverter<CourseType, String> {

    @Override
    public String convertToDatabaseColumn(CourseType courseType) {
        return switch (courseType) {
            case ELECTIVE -> CourseType.ELECTIVE.getType();
            case MANDATORY -> CourseType.MANDATORY.getType();
        };
    }

    @Override
    public CourseType convertToEntityAttribute(String s) {
        return switch (s) {
            case "Elective" -> CourseType.ELECTIVE;
            case "Mandatory" -> CourseType.MANDATORY;
            default -> throw new IllegalArgumentException("Provided Invalid values for course type.");
        };
    }

}
