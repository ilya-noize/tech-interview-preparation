package algorithms.grind75.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <a href="https://leetcode.com/problems/valid-parentheses/">valid-parentheses</a>
 */
public class ValidParentheses {

    /**
     * Stack approach We need to declare a stack to keep all opening parentheses. Once we get a
     * closing one we should check if there is the corresponding open bracket on the top of the
     * stack - If there is an opposite value there we should pop this value out of the stack - If
     * there is not that means there are not valid parentheses in given string - If the stack is
     * empty, it means that there are not valid parentheses in given string
     * <p>
     * After we loop over all the characters of the string and the stack is empty, we can say that
     * the sequence is valid
     * <p>
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (isOpeningBracket(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (hasCorrespondingClosingBracket(top, bracket)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char parenthesis) {
        return parenthesis == '['
            || parenthesis == '{'
            || parenthesis == '(';
    }

    private boolean hasCorrespondingClosingBracket(char opening, char closing) {
        return opening == '[' && closing == ']'
            || opening == '{' && closing == '}'
            || opening == '(' && closing == ')';
    }


    /**
     * The same stack decision using additional map to store brackets and clean up code
     */
    public boolean isValidUsingMap(String s) {
        Map<Character, Character> brackets = assignValidBrackets();
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (brackets.containsValue(bracket)) {
                stack.push(bracket);
            } else if (brackets.containsKey(bracket)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(bracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Map<Character, Character> assignValidBrackets() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        return brackets;
    }
}
