package stream_api.unary_operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.unary_operator.MyUnaryOperator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyUnaryOperatorTest {

    @Test
    void myIntegerUnaryOperatorTest() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        list.replaceAll(new MyUnaryOperator().integerUnaryOperator);
        Assertions.assertEquals(list, new ArrayList<>(List.of(0, 2, 0, 4, 0, 6, 0, 8, 0)));
    }

    @Test
    void myStringUnaryOperatorTest() {
        String string = "abc 123 asd";
        String apply = new MyUnaryOperator().stringUnaryOperator.apply(string);
        Assertions.assertEquals("123", apply);
    }

    @Test
    void myListStringUnaryOperatorTest() {
        List<String> strings = new ArrayList<>(List.of("1234", "12345", "123456"));
        List<String> apply = new MyUnaryOperator().listUnaryOperator.apply(strings);
        Assertions.assertEquals(new ArrayList<String>(List.of("123456")), apply);
    }

}