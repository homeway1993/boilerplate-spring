package boilerplate.spring.web.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Validate that the {@code CharSequence} matches the constants of the Enums.
 * Accept the {@code null} value.
 */
public class MatchEnumValidator implements ConstraintValidator<MatchEnum, CharSequence> {

    private Class<? extends Enum>[] enums;

    @Override
    public void initialize(MatchEnum constraintAnnotation) {
        this.enums = constraintAnnotation.enums();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return Stream.of(enums)
                .flatMap(e -> Stream.of(e.getEnumConstants()))
                .map(Object::toString)
                .anyMatch(s -> Objects.equals(value, s));
    }
}
