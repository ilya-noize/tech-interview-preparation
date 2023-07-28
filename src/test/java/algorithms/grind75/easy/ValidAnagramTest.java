package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidAnagramTest {

    private final ValidAnagram validAnagram = new ValidAnagram();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testSortingSolution(String s, String t, boolean result) {
        boolean isAnagram = validAnagram.isAnagram(s, t);
        assertEquals(result, isAnagram);
    }

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testHashMapSolution(String s, String t, boolean result) {
        boolean isAnagram = validAnagram.isAnagramHashTableApproach(s, t);
        assertEquals(result, isAnagram);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("rat", "car", false)
        );
    }
}