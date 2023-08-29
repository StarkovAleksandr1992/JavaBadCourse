package ru.starkov.second_week.climbing_stairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.climbing_stairs.ClimbingStairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {
    private ClimbingStairs climbingStairs;

    @BeforeEach
    void setUp() {
        climbingStairs = new ClimbingStairs();
    }

    @Test
    void climbStairsWithTwoWays() {
        int stairHeight = 2;
        assertEquals(2, climbingStairs.climbStairs(stairHeight));
    }

    @Test
    void climbStairsWithThreeWays() {
        int stairHeight = 3;
        assertEquals(3, climbingStairs.climbStairs(stairHeight));
    }

    @Test
    void climbStairsWithFiveWays() {
        int stairHeight = 4;
        assertEquals(5, climbingStairs.climbStairs(stairHeight));
    }

    @Test
    void climbStairsWithEightWays() {
        int stairHeight = 5;
        assertEquals(8, climbingStairs.climbStairs(stairHeight));
    }

//    @Test
//    void climbStairsWithNineWays() {
//        int stairHeight = 6;
//        assertEquals(9, climbingStairs.climbStairs(stairHeight));
//    }
}