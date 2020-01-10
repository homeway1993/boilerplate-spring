package boilerplate.spring.web.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The annotated {@code CharSequence} must match constants of the specified Enums.
 * {@code null} elements are considered valid.
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MatchEnumValidator.class})
@Repeatable(MatchEnum.List.class)
public @interface MatchEnum {

    /**
     * @return the Enums to match.
     */
    Class<? extends Enum>[] enums();

    String message() default "The format should match {enums}.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@link MatchEnum} annotations on the same element.
     *
     * @see MatchEnum
     */
    @Target({ElementType.FIELD, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {

        MatchEnum[] value();
    }
}
