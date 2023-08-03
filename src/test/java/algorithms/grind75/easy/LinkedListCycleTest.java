package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LinkedListCycleTest {

    private final LinkedListCycle linkedListCycle = new LinkedListCycle();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testRecursiveSolution(ListNode listNode1, Boolean result) {
        Boolean hasCycle = linkedListCycle.hasCycle(listNode1);
        assertEquals(result, hasCycle);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(
                new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4)))),
                true
            )
        );
    }

}