package kz.aitu.springgranted.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Converter
public class StringArrConverter implements AttributeConverter<String[], String> {
    private static final String SEPARATOR = ";";

    @Override
    public String convertToDatabaseColumn(String[] strings) {
        return String.join(SEPARATOR, strings);
    }

    @Override
    public String[] convertToEntityAttribute(String s) {
        return s.split(SEPARATOR);
    }
}
