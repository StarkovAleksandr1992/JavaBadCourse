package ru.starkov.race_condition;


import ru.starkov.util.NotThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        Map<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.putIfAbsent(i, "");
        }
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 100; i++) {
                executorService.submit(() -> {
                    int next = unsafeSequence.getNext();
                    map.computeIfPresent(next, (key, value) -> value + Thread.currentThread().getName());
                });
            }
            Thread.sleep(2000);
            System.out.println(map);
            executorService.shutdown();
            System.out.println(executorService.awaitTermination(1, TimeUnit.SECONDS));
        }
    }


    @NotThreadSafe
    public static class UnsafeSequence {
        private int value;

        public int getNext() {
            return value++;
        }
    }
}
