package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(int[] nums, int target, int[] result) {
        int[] ints = twoSum.twoSumBruteForce(nums, target);
        assertArrayEquals(result, ints);
    }

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testHashMapSolution(int[] nums, int target, int[] result) {
        int[] ints = twoSum.twoSum(nums, target);
        assertArrayEquals(result, ints);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})
        );
    }
}
