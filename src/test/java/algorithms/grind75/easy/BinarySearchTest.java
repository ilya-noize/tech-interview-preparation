package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(int[] nums, int target, int result) {
        int searchResult = binarySearch.search(nums, target);
        assertEquals(result, searchResult);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
            Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }
}