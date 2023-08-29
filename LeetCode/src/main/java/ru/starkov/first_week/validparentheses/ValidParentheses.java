package ru.starkov.first_week.validparentheses;


import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (characters.isEmpty()) {
                characters.push(s.charAt(i));
                continue;
            }
            char current = characters.peek();
            if (current == '(' && s.charAt(i) == ')') {
                characters.pop();
            } else if (current == '{' && s.charAt(i) == '}') {
                characters.pop();
            } else if (current == '[' && s.charAt(i) == ']') {
                characters.pop();
            } else {
                characters.push(s.charAt(i));
            }
        }
        return characters.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
