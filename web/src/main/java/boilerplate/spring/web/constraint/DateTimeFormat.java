package boilerplate.spring.web.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotated {@code CharSequence} must a valid date-time format.
 * {@code null} elements are considered valid.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeFormatValidator.class)
public @interface DateTimeFormat {

    /**
     * @return the pattern of date-time format.
     */
    String pattern() default "yyyy-MM-dd'T'HH:mm:ss.SSS";

    String message() default "The format should be {pattern}.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
