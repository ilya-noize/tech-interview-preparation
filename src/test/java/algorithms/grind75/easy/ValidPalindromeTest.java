package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidPalindromeTest {

    private final ValidPalindrome validPalindrome = new ValidPalindrome();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void isValid(String palindrome, boolean result) {
        boolean isPalindrome = validPalindrome.isPalindrome(palindrome);
        assertEquals(result, isPalindrome);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of(" ", true),
            Arguments.of("a", true),
            Arguments.of("a00a", true)
        );
    }
}