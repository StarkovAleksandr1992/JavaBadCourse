package ru.starkov.second_week.backspace_string_compare;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackOfS = new Stack<>();
        Stack<Character> stackOfT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stackOfS.isEmpty() && s.charAt(i) == '#') {
                continue;
            }
            if (s.charAt(i) != '#') {
                stackOfS.push(s.charAt(i));
            } else {
                stackOfS.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (stackOfT.isEmpty() && t.charAt(i) == '#') {
                continue;
            }
            if (t.charAt(i) != '#') {
                stackOfT.push(t.charAt(i));
            } else {
                stackOfT.pop();
            }
        }
        return stackOfS.equals(stackOfT);
    }
}
