package stream_api.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.comparator.MyComparator;
import ru.starkov.stream_api.predicate.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyComparatorTest {
    private MyComparator comparator;
    private List<Cat> cats;

    @BeforeEach
    void setUp() {
        cats = new ArrayList<>(List.of(new Cat(14, "Skoda"), new Cat(35, "Marta"), new Cat(3, "Dog"),
                new Cat(1, "Businka")));
        comparator = new MyComparator();
    }

    @Test
    void comparatorTest() {
        Collections.sort(cats, comparator.catComparator);
        assertEquals(3, cats.get(0).getAge());
        assertEquals(1, cats.get(cats.size() - 1).getAge());
    }

    @Test
    void absComparatorTest() {
        List<Integer> list = new ArrayList<>(List.of(4, 7, -3, -2, 10, 5, 1));

        Assertions.assertEquals(1, Collections.min(list, Comparator.comparingInt(num -> Math.abs(num))));
    }
}