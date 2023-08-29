package stream_api.predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.predicate.Cat;
import ru.starkov.stream_api.predicate.MyPredicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MyPredicateTest {

    private List<Cat> cats;
    @BeforeEach
    void setCats() {
        cats = new ArrayList<>(List.of(new Cat(1, "a"), new Cat(2, "b"), new Cat(3, "c")));
    }
    @Test
    void removeStringStartsF() {
        List<String> stringList = new ArrayList<>(List.of("Fuck", "Fill", "Job", "Done"));
        stringList.removeIf(new MyPredicate().startsWithLetterPredicate);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    void removeStringStartsWith() {
        List<String> stringList = new ArrayList<>(List.of("Fuck", "Fill", "Job", "Done"));
        char[] chars = {'F', 'D'};
        stringList.removeIf(new MyPredicate(chars).startsWithArrayPredicate);
        Assertions.assertEquals(1, stringList.size());
    }

    @Test
    void removeCatsPredicateTest() {
        cats.removeIf(new MyPredicate().catPredicate.and(new MyPredicate().catPredicate1));
        Assertions.assertEquals(2, cats.size());
    }

    @Test
    void removeEntriesTest() {
        Map<Integer,  String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "ba");
        map.put(3, "c");
        map.entrySet().removeIf((i) -> i.getKey() != i.getValue().length());
        Assertions.assertEquals(2, map.size());
    }


}