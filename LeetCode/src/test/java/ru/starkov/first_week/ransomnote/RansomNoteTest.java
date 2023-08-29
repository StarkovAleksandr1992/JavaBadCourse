package ru.starkov.first_week.ransomnote;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.ransomnote.RansomNote;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    @Test
    void canConstructFalseFirst() {
        String ransomNote = "a";
        String magazine = "b";
        assertFalse(new RansomNote().canConstruct(ransomNote, magazine));
    }

    @Test
    void canConstructFalseSecond() {
        String ransomNote = "aa";
        String magazine = "ab";
        assertFalse(new RansomNote().canConstruct(ransomNote, magazine));
    }

    @Test
    void canConstructTrueFirst() {
        String ransomNote = "a";
        String magazine = "a";
        assertTrue(new RansomNote().canConstruct(ransomNote, magazine));
    }
    @Test
    void canConstructTrueSecond() {
        String ransomNote = "acab";
        String magazine = "caaba";
        assertTrue(new RansomNote().canConstruct(ransomNote, magazine));
    }
}