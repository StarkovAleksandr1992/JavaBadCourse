package stream_api.consumer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.stream_api.consumer.MyConsumer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyConsumerTest {
    private final PrintStream defaultOut = System.out;
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(byteArrayOutputStream);

    @BeforeEach
    void setSystemOut() {

        System.setOut(printStream);
    }

    @AfterEach
    void setDefaultSystemOut() {
        System.setOut(defaultOut);
    }

    @Test
    void myConsumerTest() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        list.forEach(new MyConsumer().integerConsumer);
        Assertions.assertEquals("246810", byteArrayOutputStream.toString().replaceAll("\r\n", ""));
    }

    @Test
    void myStringConsumerTest() {
        MyConsumer myConsumer = new MyConsumer();
        List<String> ans = new ArrayList<>(List.of("1a", "2b"));
        List<String> list = new ArrayList<>(List.of("1a", "2b", "b", "c"));
        list.forEach(myConsumer.stringConsumer);
        assertEquals(ans, myConsumer.getStringContainsDigit());
    }

}