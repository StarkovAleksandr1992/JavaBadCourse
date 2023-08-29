package ru.starkov.first_week.binarysearch;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.binarysearch.BinarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {


    @Test
    void search() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(4, binarySearch.search(nums, 9));
    }
}