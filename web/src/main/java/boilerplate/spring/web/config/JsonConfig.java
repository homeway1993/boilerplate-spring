package boilerplate.spring.web.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class JsonConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Value("${spring.date-time-format:yyyy-MM-dd'T'HH:mm:ss.SSS}")
    private String dateTimeFormat;

    /**
     * Set the fixed date-time format,
     * or the ObjectMapper will show different digits of milliseconds according to different JVM versions.
     */
    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
    }
}
