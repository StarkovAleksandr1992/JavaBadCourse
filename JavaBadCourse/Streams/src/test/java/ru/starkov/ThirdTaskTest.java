package ru.starkov;

import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.util.Cat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ThirdTaskTest {
    private ThirdTask thirdTask;

    @BeforeEach
    void setUp() {
        thirdTask = new ThirdTask();
    }

    @Test
    void longestNameTest() {
        List<Cat> cats = new ArrayList<>(List.of(new Cat("Barsik", 3,3), new Cat("Skoda", 14, 4),
                new Cat("Murka", 9, 4)));
        assertEquals("Barsik", thirdTask.longestName(cats));
    }
}