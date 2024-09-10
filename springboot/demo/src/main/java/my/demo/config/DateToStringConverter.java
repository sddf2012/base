package my.demo.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.SimpleDateFormat;

@Converter
public class DateToStringConverter implements AttributeConverter<Date, String> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String convertToDatabaseColumn(Date date) {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    public Date convertToEntityAttribute(String dateString) {
        if (dateString == null) {
            return null;
        }
        try {
            return sdf.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}
