package algorithms.grind75.easy;

import algorithms.grind75.domain.ListNode;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a
 * cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter. Return true
 * if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * <a href="https://leetcode.com/problems/linked-list-cycle/">linked-list-cycle</a>
 */
public class LinkedListCycle {

    /**
     * Use two pointer way to find out if there is a cycle in linked list.
     * Let's assign slow pointer and fast pointer, if fast pointer reaches slow - than we can be sure
     * that we've found a cycle
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = head.next.next;
            slow = head.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
