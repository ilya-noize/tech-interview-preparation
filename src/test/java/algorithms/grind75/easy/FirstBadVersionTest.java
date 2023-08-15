package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FirstBadVersionTest {

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(int n, int badVersion) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(badVersion);
        int result = firstBadVersion.firstBadVersion(n);
        assertEquals(badVersion, result);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(5, 4),
            Arguments.of(1, 1)
        );
    }

}
