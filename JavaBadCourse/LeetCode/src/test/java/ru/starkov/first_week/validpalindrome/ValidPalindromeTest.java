package ru.starkov.first_week.validpalindrome;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.validpalindrome.ValidPalindrome;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void itsFirstTruePalindrome() {
        String example = "Aman, a plan, a canal: Panama";
        assertTrue(ValidPalindrome.isPalindrome(example));
    }
    @Test
    void itsSecondTruePalindrome() {
        String example = "level";
        assertTrue(ValidPalindrome.isPalindrome(example));
    }

    @Test
    void itsFalsePalindrome() {
        String example = "Aman, a plan, a canal: Panam";
        assertFalse(ValidPalindrome.isPalindrome(example));
    }
}