package stream_api.comparable;

import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.comparable.MyComparable;
import ru.starkov.stream_api.comparable.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyComparableTest {

    @Test
    void findMaxTest() {
        Rectangle[] rectangles = {new Rectangle(1, 1), new Rectangle(5, 5), new Rectangle(2, 1)};
        MyComparable<Rectangle> myComparable = new MyComparable<>();
        Rectangle max = myComparable.findMax(rectangles);
        assertEquals(new Rectangle(5, 5), max);
    }

}