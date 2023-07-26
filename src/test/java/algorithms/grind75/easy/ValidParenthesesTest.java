package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesesTest {

    private final ValidParentheses validParentheses = new ValidParentheses();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testStackSolution(String parentheses, boolean result) {
        boolean valid = validParentheses.isValid(parentheses);
        assertEquals(result, valid);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("]", false),
            Arguments.of("(])", false)
        );
    }
}