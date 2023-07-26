package ru.starkov.third_week.insert_interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        int newStartValue = newInterval[0];
        int newEndValue = newInterval[1];

        while (i < n && intervals[i][1] < newStartValue) {
            resultList.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newEndValue) {
            newStartValue = Math.min(newStartValue, intervals[i][0]);
            newEndValue = Math.max(newEndValue, intervals[i][1]);
            i++;
        }

        resultList.add(new int[]{newStartValue, newEndValue});

        while (i < n) {
            resultList.add(intervals[i]);
            i++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}

