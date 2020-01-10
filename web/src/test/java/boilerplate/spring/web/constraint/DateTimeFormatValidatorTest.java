package boilerplate.spring.web.constraint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class DateTimeFormatValidatorTest {

    @InjectMocks
    private DateTimeFormatValidator validator;

    @Before
    public void setUp() {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        ReflectionTestUtils.setField(validator, "pattern", pattern);
    }

    @Test
    public void isValid() {
        boolean result = validator.isValid("2020-01-01T00:00:00.000", null);
        assertTrue(result);
    }

    @Test
    public void isValidWithNullValue() {
        boolean result = validator.isValid(null, null);
        assertTrue(result);
    }

    @Test
    public void isValidWithWrongString() {
        boolean result = validator.isValid("xxx", null);
        assertFalse(result);
    }
}