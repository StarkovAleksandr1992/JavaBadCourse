package stream_api.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.function.MyFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyFunctionTest {

    private MyFunction myFunction;

    @BeforeEach
    void setUp() {
        myFunction = new MyFunction();
    }

    @Test
    void countPrimeNumbersTest() {
        Integer[] integers = {5, 6, 7, 8, 9, 10, 12};
        assertEquals(2, myFunction.function.apply(integers));
    }

    @Test
    void sumCodesOfCharsTest() {
        String s = "asd";
        assertEquals(312, myFunction.sumCodesOfChars.apply(s));
    }

    @Test
    void returnSameWords() {
        String s1 = "Hello Java";
        String s2 = "Hello C";
        assertEquals("Hello", myFunction.stringStringBiFunction.apply(s1, s2).get(0));
    }
}