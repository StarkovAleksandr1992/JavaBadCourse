package ru.starkov.first_week.implementqueueusingstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.first_week.implementqueueusingstack.ImplementQueueUsingStack;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ImplementQueueUsingStackTest {

    private ImplementQueueUsingStack queue;

    @BeforeEach
    void setQueue() {
        queue = new ImplementQueueUsingStack();
    }

    @Test
    void pushOneElement() {
        queue.push(1);
        assertFalse(queue.empty());
    }
    @Test
    void pushTwoElements() {
        queue.push(1);
        queue.push(2);


    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
    }

    @Test
    void empty() {
    }
}