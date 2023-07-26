package ru.starkov.second_week.backspace_string_compare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.backspace_string_compare.BackspaceStringCompare;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackspaceStringCompareTest {

    private BackspaceStringCompare backspaceStringCompare;

    @BeforeEach
    void setUp() {
        backspaceStringCompare = new BackspaceStringCompare();
    }

    @Test
    void backspaceCompareReturnsTrue() {
        String s = "ab#c", t = "ad#c";
        assertTrue(backspaceStringCompare.backspaceCompare(s, t));
    }

    @Test
    void backspaceCompareReturnsTrue1() {
        String s = "ab##", t = "c#d#";
        assertTrue(backspaceStringCompare.backspaceCompare(s, t));
    }

    @Test
    void backspaceCompareReturnsTrue2() {
        String s = "a##c", t = "#a#c";
        assertTrue(backspaceStringCompare.backspaceCompare(s, t));

    }

    @Test
    void backspaceCompareReturnsFalse() {
        String s = "a#c", t = "b";
        assertFalse(backspaceStringCompare.backspaceCompare(s, t));
    }

}