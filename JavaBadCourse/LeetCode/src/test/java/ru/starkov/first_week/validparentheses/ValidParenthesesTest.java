package ru.starkov.first_week.validparentheses;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.validparentheses.ValidParentheses;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void itIsValidString1() {
        String s = "{}{}[]()";
        assertTrue(ValidParentheses.isValid(s));
    }

    @Test
    void itIsInvalidString1() {
        String s = "{(})[]()";
        assertFalse(ValidParentheses.isValid(s));
    }

    @Test
    void itIsInvalidString2() {
        String s = "({})[]())";
        assertFalse(ValidParentheses.isValid(s));
    }
    @Test
    void itIsValidString2() {
        String s = "({[{}{}[]()]})";
        assertTrue(ValidParentheses.isValid(s));
    }

}