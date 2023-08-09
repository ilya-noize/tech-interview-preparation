package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MiddleOfTheLinkedListTest {

    private final MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testRecursiveSolution(ListNode listNode, ListNode result) {
        ListNode middleNode = middleOfTheLinkedList.middleNode(listNode);
        assertEquals(result, middleNode);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            //Input: [1,2,3,4,5]
            //Output: [3,4,5]
            Arguments.of(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(3, new ListNode(4, new ListNode(5)))
            ),
            //Input: [1,2,3,4,5,6]
            //Output: [4,5,6]
            Arguments.of(
                new ListNode(1, new ListNode(2, new ListNode(3,
                    new ListNode(4, new ListNode(5, new ListNode(6)))))),
                new ListNode(4, new ListNode(5, new ListNode(6)))
            )
        );
    }

}