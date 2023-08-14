package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContainsDuplicateTest {

    private final ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testHashMapSolution(int[] nums, boolean result) {
        boolean contains = containsDuplicate.containsDuplicateHashMap(nums);
        assertEquals(result, contains);
    }

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testSetSolution(int[] nums, boolean result) {
        boolean contains = containsDuplicate.containsDuplicateSet(nums);
        assertEquals(result, contains);
    }

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testSortingSolution(int[] nums, boolean result) {
        boolean contains = containsDuplicate.containsDuplicate(nums);
        assertEquals(result, contains);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, true),
            Arguments.of(new int[]{1, 2, 3, 4}, false),
            Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}