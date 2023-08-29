package ru.starkov.first_week.ransomnote;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] magaz = magazine.codePoints().sorted().toArray();
        List<Integer> ransom = ransomNote.codePoints().boxed().sorted(Comparator.reverseOrder()).toList();
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : ransom) {
            stack.push(integer);
        }

        for (int j : magaz) {
            if (j == stack.peek()) {
                stack.pop();
                if (stack.size() == 0) {
                    break;
                }
            }
        }
        return stack.size() == 0;
    }
}