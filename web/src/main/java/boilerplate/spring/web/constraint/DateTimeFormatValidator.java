package boilerplate.spring.web.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validate that the {@code CharSequence} can parse to LocalDateTime by {@link DateTimeFormatter#parse(CharSequence)}
 * Accept the {@code null} value.
 *
 * @see DateTimeFormatter
 */
public class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormat, CharSequence> {

    private String pattern;

    @Override
    public void initialize(DateTimeFormat constraintAnnotation) {
        pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        try {
            DateTimeFormatter.ofPattern(pattern).parse(value);
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }
}
