package domain.converter;

import domain.enums.CourseType;
import domain.enums.ModuleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ModuleTypeConverter implements AttributeConverter<ModuleType, String> {

    @Override
    public String convertToDatabaseColumn(ModuleType moduleType) {
        return switch (moduleType) {
            case UNDERGRADUATE -> ModuleType.UNDERGRADUATE.getType();
            case MASTERS -> ModuleType.MASTERS.getType();
            case POSTGRADUATE -> ModuleType.POSTGRADUATE.getType();
        };
    }

    @Override
    public ModuleType convertToEntityAttribute(String s) {
        return switch (s) {
            case "Undergraduate" -> ModuleType.UNDERGRADUATE;
            case "Masters" -> ModuleType.MASTERS;
            case "Postgraduate" -> ModuleType.POSTGRADUATE;
            default -> throw new IllegalArgumentException("Provided Invalid values for module type.");
        };
    }

}
