package domain.converter;

import domain.enums.CourseAvailability;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CourseAvailabilityConverter implements AttributeConverter<CourseAvailability, String> {

    @Override
    public String convertToDatabaseColumn(CourseAvailability courseAvailability) {
        return switch (courseAvailability) {
            case I_SEMESTER -> "I";
            case II_SEMESTER -> "II";
            case III_SEMESTER -> "III";
            case IV_SEMESTER -> "IV";
            case V_SEMESTER -> "V";
            case VI_SEMESTER -> "VI";
            case VII_SEMESTER -> "VII";
            case VIII_SEMESTER -> "VIII";
        };
    }

    @Override
    public CourseAvailability convertToEntityAttribute(String s) {
        return switch (s) {
            case "I" -> CourseAvailability.I_SEMESTER;
            case "II" -> CourseAvailability.II_SEMESTER;
            case "III" -> CourseAvailability.III_SEMESTER;
            case "IV" -> CourseAvailability.IV_SEMESTER;
            case "V" -> CourseAvailability.V_SEMESTER;
            case "VI" -> CourseAvailability.VI_SEMESTER;
            case "VII" -> CourseAvailability.VII_SEMESTER;
            case "VIII" -> CourseAvailability.VIII_SEMESTER;
            default -> throw new IllegalArgumentException("Provided Invalid values for course availability.");
        };
    }

}
