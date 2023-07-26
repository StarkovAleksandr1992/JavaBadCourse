package stream_api.comparable;

import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.comparable.Rectangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RectangleTest {

    @Test
    void compareToTest() {
        List<Rectangle> list = new ArrayList<>(List.of(new Rectangle(1, 1), new Rectangle(5, 5), new Rectangle(2, 1)));
        list.sort(Comparator.naturalOrder());
        assertEquals(new Rectangle(1, 1), list.get(0));
        assertEquals(25, list.get(2).getSquare());
    }
}