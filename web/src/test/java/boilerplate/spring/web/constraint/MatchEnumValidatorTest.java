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
public class MatchEnumValidatorTest {

    @InjectMocks
    private MatchEnumValidator validator;

    @Before
    public void setUp() {
        Class[] enums = new Class[]{Test1.class, Test2.class};
        ReflectionTestUtils.setField(validator, "enums", enums);
    }

    @Test
    public void isValid() {
        boolean result = validator.isValid("D", null);
        assertTrue(result);
    }

    @Test
    public void isValidWithNullValue() {
        boolean result = validator.isValid(null, null);
        assertTrue(result);
    }

    @Test
    public void isValidWithWrongValue() {
        boolean result = validator.isValid("wrong", null);
        assertFalse(result);
    }

    private enum Test1 {
        A, B
    }

    private enum Test2 {
        D, E
    }
}