package ru.starkov.runnable_counter;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            value = scanner.nextInt();
            executorService.submit(new RunnableCounter(value));
        } while (value >= 0);
        executorService.shutdown();
        executorService.awaitTermination(10L, TimeUnit.SECONDS);

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        do {
            value = scanner.nextInt();
            Future<?> submit = executorService1.submit(new RunnableCounter(value));
            Future.State state = submit.state();
        } while (value >= 0);

        System.out.println(RunnableCounter.counter);
        executorService1.shutdown();
        executorService1.awaitTermination(10L, TimeUnit.SECONDS);

    }

}
