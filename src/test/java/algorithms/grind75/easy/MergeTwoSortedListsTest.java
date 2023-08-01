package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeTwoSortedListsTest {

    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(ListNode listNode1, ListNode listNode2, ListNode result) {
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);
        assertEquals(result, listNode);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            //Input: list1 = [1,2,4], list2 = [1,3,4]
            //Output: [1,1,2,3,4,4]
            Arguments.of(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(1, new ListNode(1, new ListNode(2,
                    new ListNode(3, new ListNode(4, new ListNode(4))))))
            )
        );
    }
}