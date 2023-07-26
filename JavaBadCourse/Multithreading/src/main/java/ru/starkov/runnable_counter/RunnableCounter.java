package ru.starkov.runnable_counter;

import java.util.concurrent.ConcurrentHashMap;

public class RunnableCounter implements Runnable {

    private final int seconds;
    public static ConcurrentHashMap<String, Integer> counter = new ConcurrentHashMap<>();

    public RunnableCounter(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds * 1000L);
            counter.putIfAbsent(Thread.currentThread().getName() + Thread.currentThread().threadId(), 1);
            counter.computeIfPresent(Thread.currentThread().getName() + Thread.currentThread().threadId(), (name, count) -> count + 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Я спал %d секунд \n", seconds);
    }
}
