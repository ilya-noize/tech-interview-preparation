package algorithms.grind75.easy;

import algorithms.grind75.domain.ListNode;

/**
 * 206. Reverse Linked List
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * <a href="https://leetcode.com/problems/reverse-linked-list/">reverse-linked-list</a>
 */
public class ReverseLinkedList {

    /**
     * Use two pointer approach to solve this problem.
     * The prev pointer starts as null because the last node in the reversed list will have no successor.
     * The current pointer starts at the head of the original list.
     * While loop iterates through the linked list, and for each node:
     * The nextTemp pointer is used to temporarily store the next node.
     * The current.next pointer is updated to point to the previous node (prev),
     * effectively reversing the direction of the linked list.
     * The prev pointer is moved forward to the current node.
     * The current pointer is moved forward to the next node using the nextTemp pointer.
     * After the loop completes, the prev pointer points to the head of the reversed linked list.
     * So, we return prev as the new head.
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }

        return prev;
    }
}
