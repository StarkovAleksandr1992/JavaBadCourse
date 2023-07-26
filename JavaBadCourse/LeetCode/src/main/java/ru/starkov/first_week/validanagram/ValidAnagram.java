package ru.starkov.first_week.validanagram;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] ints = s.codePoints().sorted().toArray();
        int[] ints1 = t.codePoints().sorted().toArray();
        return Arrays.equals(ints1, ints);
    }
}
