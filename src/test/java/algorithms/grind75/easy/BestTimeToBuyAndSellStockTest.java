package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BestTimeToBuyAndSellStockTest {

    private final BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(int[] nums, int result) {
        int searchResult = stock.maxProfit(nums);
        assertEquals(result, searchResult);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
            Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}