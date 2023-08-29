package ru.starkov.second_week.add_binary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddBinaryTest {
    private AddBinary addBinary;

    @BeforeEach
    void setUp() {
        addBinary = new AddBinary();
    }

    @Test
    void addBinaryFirst() {
        String a = "11";
        String b = "1";

        assertEquals("100", addBinary.addBinary(a, b));
    }

    @Test
    void addBinarySecond() {
        String a = "1010";
        String b = "1011";

        assertEquals("10101", addBinary.addBinary(a, b));
    }

    @Test
    void addBinaryThird() {
        String a = "10";
        String b = "1";

        assertEquals("11", addBinary.addBinary(a, b));
    }

    @Test
    void addBinaryFourth() {
        String a = "1111";
        String b = "1111";

        assertEquals("11110", addBinary.addBinary(a, b));
    }

}