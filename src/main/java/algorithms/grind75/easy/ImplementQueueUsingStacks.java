package algorithms.grind75.easy;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * <p>
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should
 * support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class: void push(int x) Pushes element x to the back of the queue. int
 * pop() Removes the element from the front of the queue and returns it. int peek() Returns the
 * element at the front of the queue. boolean empty() Returns true if the queue is empty, false
 * otherwise. Notes:
 * <p>
 * You must use only standard operations of a stack, which means only push to top, peek/pop from
 * top, size, and is empty operations are valid. Depending on your language, the stack may not be
 * supported natively. You may simulate a stack using a list or deque (double-ended queue) as long
 * as you use only a stack's standard operations.
 * <p>
 * <a
 * href="https://leetcode.com/problems/implement-queue-using-stacks/">implement-queue-using-stacks</a>
 */
public class ImplementQueueUsingStacks {

    /**
     * We should use two stacks to simulate the behavior of enqueue and dequeue operations
     * <p>
     * Space Complexity: O(n) where n is the number of elements in the queue
     */
    private final Stack<Integer> inStack;  // Used for enqueue
    private final Stack<Integer> outStack; // Used for dequeue

    // initialize stacks via constructor
    public ImplementQueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Move elements from inStack to outStack if outStack is empty
    // need for poop and peek operations
    //
    private void shiftData() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    // put item into inStack
    // Time Complexity: O(1)
    public void push(int x) {
        inStack.push(x);
    }

    // move data from end to the beginning of the queue and take first value from the top of out stack
    // Time Complexity: amortized O(1) each element is transferred only once from inStack to outStack
    public int pop() {
        shiftData();
        return outStack.pop();
    }

    // move data from end to the beginning of the queue and peek first value from the top of out stack
    // Time Complexity: amortized O(1) each element is transferred only once from inStack to outStack
    public int peek() {
        shiftData();
        return outStack.peek();
    }

    // queue is empty if both in and out stack is empty
    // Time Complexity: O(1)
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
