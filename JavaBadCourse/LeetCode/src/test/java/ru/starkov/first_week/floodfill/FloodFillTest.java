package ru.starkov.first_week.floodfill;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.floodfill.FloodFill;

import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {

    @Test
    void floodFill() {
        FloodFill floodFill = new FloodFill();
        int[][] example = new int[][]{{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        int[][] answer = new int[][]{{2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}};

        assertArrayEquals(answer, floodFill.floodFill(example, 1, 1, 2));
    }

    @Test
    void floodFillZero() {
        FloodFill floodFill = new FloodFill();
        int[][] example = new int[][]{{0, 0, 0},
                {2, 0, 0}};
        int[][] answer = new int[][]{{2, 2, 2},
                {2, 2, 2}};
        assertArrayEquals(answer, floodFill.floodFill(example, 0, 1, 2));
    }
}