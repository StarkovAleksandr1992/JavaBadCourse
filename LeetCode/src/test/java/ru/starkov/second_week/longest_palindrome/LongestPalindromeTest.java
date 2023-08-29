package ru.starkov.second_week.longest_palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.longest_palindrome.LongestPalindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    private LongestPalindrome longestPalindrome;

    @BeforeEach
    void setUp() {
        longestPalindrome = new LongestPalindrome();
    }

    @Test
    void longestPalindromeFirst() {
        String s = "!!фывфыв^^\uD83D\uDE00";
        assertEquals(11, longestPalindrome.longestPalindrome(s));
    }

    @Test
    void longestPalindromeSecond() {
        String s = "a";
        assertEquals(1, longestPalindrome.longestPalindrome(s));
    }
}