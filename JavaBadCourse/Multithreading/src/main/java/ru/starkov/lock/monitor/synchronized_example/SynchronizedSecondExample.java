package ru.starkov.lock.monitor.synchronized_example;


import ru.starkov.util.ThreadInfoExecutionProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SynchronizedSecondExample implements Runnable {


    private List<Integer> list;

    public SynchronizedSecondExample(List<Integer> list) {
        this.list = list;
    }

    private final Random random = new Random();
    @Override
    public void run() {
        list.add(random.nextInt());

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> list1 = new ArrayList<>();
        SynchronizedSecondExample synchronizedSecondExample = new SynchronizedSecondExample(list1);
        ThreadInfoExecutionProxy threadInfoExecutionProxy = new ThreadInfoExecutionProxy(synchronizedSecondExample);
        Runnable proxy = (Runnable) threadInfoExecutionProxy.createProxy();
        System.out.println(list1);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
//            synchronized (list1) {
                Future<?> submit = executorService.submit(proxy);
//            }
        }

        executorService.close();
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }
}
