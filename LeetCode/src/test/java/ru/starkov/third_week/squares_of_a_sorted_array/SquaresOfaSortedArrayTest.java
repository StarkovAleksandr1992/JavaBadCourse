package ru.starkov.third_week.squares_of_a_sorted_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.squares_of_a_sorted_array.SquaresOfaSortedArray;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfaSortedArrayTest {

    private SquaresOfaSortedArray squaresOfaSortedArray;

    @BeforeEach
    void setUp() {
        squaresOfaSortedArray = new SquaresOfaSortedArray();
    }

    @Test
    void sortedSquaresFirstTest() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ans = {0, 1, 9, 16, 100};
        assertArrayEquals(ans, squaresOfaSortedArray.sortedSquares(nums));
    }

    @Test
    void sortedSquaresSecondTest() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] ans = {4, 9, 9, 49, 121};
        assertArrayEquals(ans, squaresOfaSortedArray.sortedSquares(nums));
    }
}