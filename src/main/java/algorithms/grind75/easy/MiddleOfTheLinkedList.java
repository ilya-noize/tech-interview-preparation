package algorithms.grind75.easy;

import algorithms.grind75.domain.ListNode;

/**
 * 876. Middle of the Linked List
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list. If there are
 * two middle nodes, return the second middle node.
 * <p>
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">middle-of-the-linked-list</a>
 */
public class MiddleOfTheLinkedList {

    /**
     * Used two pointers way to figure out the middle node. First pointer should be fast and go
     * through one node and second one should be slow and iterate each node. When the fast pointer
     * reaches the end (is null and fast.next is null) the slow one would be at the middle node
     * <p>
     * Time Complexity: O(n/2), which is equivalent to O(n) in terms of big O notation. Space
     * Complexity: O(n) since only a constant amount of extra space is used for the two pointers.
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
