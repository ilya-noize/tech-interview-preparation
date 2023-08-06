package algorithms.grind75.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchInRotatedSortedArrayTest {

    private final SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(int[] nums, int target, int result) {
        int searchResult = search.search(nums, target);
        assertEquals(result, searchResult);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
            Arguments.of(new int[]{1}, 0, -1)
        );
    }

}