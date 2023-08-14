package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseLinkedListTest {

    private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testSolution(ListNode listNode, ListNode result) {
        ListNode reversedLinkedList = reverseLinkedList.reverseList(listNode);
        assertEquals(result, reversedLinkedList);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            //Input: [1,2,3,4,5]
            //Output: [5,4,3,2,1]
            Arguments.of(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))
            ),
            //Input: []
            //Output: []
            Arguments.of(null, null)
        );
    }
}
