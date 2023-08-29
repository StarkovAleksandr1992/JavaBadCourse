package ru.starkov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class SecondTaskTest {

    private SecondTask secondTask;

    @BeforeEach
    void setUp() {
        secondTask = new SecondTask();
    }

    @Test
    void findUniqueStringsFirstTest() {
        String str = "\"Hello there\"\n" +
                "\"Good morning\"\n" +
                "\"OpenAI is amazing\"\n" +
                "\"Coding is fun\"\n" +
                "\"Learning new things\"\n" +
                "\"Summer breeze\"\n" +
                "\"Rainbow colors\"\n" +
                "\"Coffee lovers\"\n" +
                "\"Music brings joy\"\n" +
                "\"Exploring the world\"\n" +
                "\"Nature's beauty\"\n" +
                "\"Creating art\"\n" +
                "\"Happy moments\"\n" +
                "\"Laugh out loud\"\n" +
                "\"Dream big\"";
        List<String> strings1 = Arrays.stream(str.split("\n")).toList();
        int ans = 0;
        for (String s : strings1) {
            if (s.length() > 10) {
                ans++;
            }
        }
        assertEquals(ans, secondTask.findUniqueStrings(strings1));
    }
    @Test
    void findUniqueStringsSecondTest() {
        String str = "\"Hello there\"\n" +
                "\"Good morning\"\n" +
                "\"OpenAI is amazing\"\n" +
                "\"Coding is fun\"\n" +
                "\"Learning new things\"\n" +
                "\"Learning new things\"\n" +
                "\"Learning new things\"\n" +
                "\"Summer breeze\"\n" +
                "\"Rainbow colors\"\n" +
                "\"Coffee lovers\"\n" +
                "\"Music brings joy\"\n" +
                "\"Exploring the world\"\n" +
                "\"Nature's beauty\"\n" +
                "\"Creating art\"\n" +
                "\"Happy moments\"\n" +
                "\"Laugh out loud\"\n" +
                "\"Dream big\"";
        List<String> strings1 = Arrays.stream(str.split("\n")).toList();
        int ans = 0;
        for (String s : strings1) {
            if (s.length() > 10) {
                ans++;
            }
        }
        assertEquals(ans - 2, secondTask.findUniqueStrings(strings1));
    }
}