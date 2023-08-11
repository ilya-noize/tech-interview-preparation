package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RansomNoteTest {

    private final RansomNote note = new RansomNote();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(String ransomNote, String magazine, boolean result) {
        boolean canConstruct = note.canConstruct(ransomNote, magazine);
        assertEquals(result, canConstruct);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of("aa", "aab", true),
            Arguments.of("aa", "ab", false),
            Arguments.of("a", "b", false)
        );
    }

}