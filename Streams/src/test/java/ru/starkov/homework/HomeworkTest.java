package ru.starkov.homework;

import org.junit.jupiter.api.Test;
import ru.starkov.util.Man;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    private static final List<String> strings = new ArrayList<>(List.of("1", "2", "3", "1"));
    private static final List<String> emptyList = List.of();

    @Test
    void countObject() {
        String str = "1";
        long ans = 2L;
        assertEquals(2, Homework.countObject(strings, str));
    }


    @Test
    void getFirst() {
        String ans = "1";
        assertEquals(ans, Homework.getFirst(strings));
        assertNull(Homework.getFirst(emptyList));
    }

    @Test
    void getLast() {
        String ans = "1";
        assertEquals(ans, Homework.getLast(strings));
        assertNull(Homework.getLast(emptyList));
    }

    @Test
    void contains() {
        boolean ans1 = true;
        boolean ans2 = false;
        String str = "2";
        assertTrue(Homework.contains(strings, str));
        assertFalse(Homework.contains(emptyList, str));
    }

    @Test
    void getByPosition() {
        String ans1 = "1";
        String ans2 = "2";
        assertEquals(ans1, Homework.getByPosition(strings, 1));
        assertEquals(ans1, Homework.getByPosition(strings, 4));
        assertEquals(ans2, Homework.getByPosition(strings, 2));
        assertThrows(IllegalArgumentException.class, () -> Homework.getByPosition(strings, 6));
    }

    @Test
    void liableForMilitaryService() {
        assertEquals(Man.liableForMilitaryServiceMans, Homework.liableForMilitaryService(Man.men));
    }

    @Test
    void averageAge() {
        int sumAge = 0;
        for (Man man : Man.men) {
            sumAge += man.getAge();
        }
        int averageAge = sumAge / Man.men.size();
        assertEquals(averageAge, Homework.averageAge(Man.men));
    }
}