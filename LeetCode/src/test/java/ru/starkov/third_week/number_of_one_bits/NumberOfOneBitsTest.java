package ru.starkov.third_week.number_of_one_bits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfOneBitsTest {
    private NumberOfOneBits numberOfOneBits;

    @BeforeEach
    void setUp() {
        numberOfOneBits = new NumberOfOneBits();
    }

    @Test
    void hammingWeight() {
        assertEquals(3, numberOfOneBits.hammingWeight(0b00000000000000000000000000001011));
    }
}