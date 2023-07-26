package ru.starkov.third_week.move_zeroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.move_zeroes.MoveZeroes;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    private MoveZeroes moveZeroes;

    @BeforeEach
    void setUp() {
        moveZeroes = new MoveZeroes();
    }

    @Test
    void moveZeroesFirstTest() {
        int[] ans = {1, 3, 12, 0, 0};
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesSecondTest() {
        int[] ans = {0};
        int[] nums = {0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesThirdTest() {
        int[] ans = {1, 2, 0, 0, 0};
        int[] nums = {0, 0, 0, 1, 2};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesFourthTest() {
        int[] ans = {1, 0};
        int[] nums = {1, 0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesFifthTest() {
        int[] ans = {1, 2, 0, 0, 0};
        int[] nums = {1, 0, 0, 0, 2};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesSixthTest() {
        int[] ans = {2, 1};
        int[] nums = {2, 1};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }

    @Test
    void moveZeroesSeventhTest() {
        int[] ans = {4,2,4,3,5,1,0,0,0,0};
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(ans, nums);
    }
}