package ru.starkov.first_week.validanagram;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.validanagram.ValidAnagram;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void itsFirstValidAnagram() {
        String s = "asdfg";
        String t = "gfdsa";
        assertTrue(ValidAnagram.isAnagram(s, t));
    }
    @Test
    void itsSecondValidAnagram() {
        String s = "anagram";
        String t = "nagaram";
        assertTrue(ValidAnagram.isAnagram(s, t));
    }

    @Test
    void itsFirstInvalidAnagram() {
        String s = "qwerty";
        String t = "trewq";
        assertFalse(ValidAnagram.isAnagram(s, t));
    }
    @Test
    void itsSecondInvalidAnagram() {
        String s = "qwerty";
        String t = "qtrewq";
        assertFalse(ValidAnagram.isAnagram(s, t));
    }
}