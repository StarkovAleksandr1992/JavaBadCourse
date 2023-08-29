package ru.starkov.third_week.insert_interval;

import org.junit.jupiter.api.Test;
import ru.starkov.third_week.insert_interval.InsertInterval;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntervalTest {

    @Test
    void insert() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = InsertInterval.insert(intervals, newInterval);
        int[][] answer = {{1, 5}, {6, 9}};
        assertArrayEquals(answer, insert);

    }

    @Test
    void insert1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 7};
        int[][] insert = InsertInterval.insert(intervals, newInterval);
        int[][] answer = {{1, 9}};
        assertArrayEquals(answer, insert);

    }

    @Test
    void insert2() {
        int[][] intervals = {{1, 3}, {4, 6}, {7, 9}};
        int[] newInterval = {2, 7};
        int[][] insert = InsertInterval.insert(intervals, newInterval);
        int[][] answer = {{1, 9}};
        assertArrayEquals(answer, insert);
    }

    @Test
    void insert3() {
        int[][] intervals = {{1, 3}, {4, 6}, {7, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = InsertInterval.insert(intervals, newInterval);
        int[][] answer = {{1, 6}, {7, 9}};
        assertArrayEquals(answer, insert);
    }

    @Test
    void insert4() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = InsertInterval.insert(intervals, newInterval);
        int[][] answer = {{1, 5}, {6, 9}};
        assertArrayEquals(answer, insert);
    }
}