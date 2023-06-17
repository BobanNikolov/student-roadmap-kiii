package domain.converter;

import domain.enums.StudentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StudentTypeConverter implements AttributeConverter<StudentType, String> {

    @Override
    public String convertToDatabaseColumn(StudentType moduleType) {
        return switch (moduleType) {
            case UNDERGRADUATE -> StudentType.UNDERGRADUATE.getType();
            case MASTERS -> StudentType.MASTERS.getType();
            case POSTGRADUATE -> StudentType.POSTGRADUATE.getType();
        };
    }

    @Override
    public StudentType convertToEntityAttribute(String s) {
        return switch (s) {
            case "Undergraduate" -> StudentType.UNDERGRADUATE;
            case "Masters" -> StudentType.MASTERS;
            case "Postgraduate" -> StudentType.POSTGRADUATE;
            default -> throw new IllegalArgumentException("Provided Invalid values for student type.");
        };
    }

}
