package ru.starkov.lock.monitor.synchronized_example;

import ru.starkov.util.Incrementable;
import ru.starkov.util.MethodExecutionTimeProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SynchronizedFirstExample implements Incrementable {
    private int value;
    private volatile int syncValue;

    @Override
    public void incrementValue() {
        value++;
    }

    @Override
    public synchronized void incrementValueSync() {
        syncValue++;
    }

    //для получения jvm error
    private void doSomething() {
        doSomething();
    }

    public static void main(String[] args) throws Throwable {
        SynchronizedFirstExample synchronizedExample = new SynchronizedFirstExample();
        MethodExecutionTimeProxy methodExecutionTimeProxy = new MethodExecutionTimeProxy(synchronizedExample);
        Incrementable proxy = (Incrementable) methodExecutionTimeProxy.createProxy();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1_000_000; i++) {
            executorService.submit(proxy::incrementValue);
        }
        Thread.sleep(3000);
        System.out.println(synchronizedExample.value);
        System.out.println(methodExecutionTimeProxy.getTotalExecutionTime());
        methodExecutionTimeProxy.setTotalExecutionTime(0);
        for (int i = 0; i < 1_000_000; i++) {
            executorService.submit(proxy::incrementValueSync);
        }
        Thread.sleep(3000);
        System.out.println(synchronizedExample.syncValue);
        System.out.println(methodExecutionTimeProxy.getTotalExecutionTime());
        synchronizedExample.value = 0;
        methodExecutionTimeProxy.setTotalExecutionTime(0);
        List<Callable<Void>> callables = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            callables.add(() -> {
                proxy.incrementValue();
                return null;
            });
        }
        List<Future<Void>> futures = executorService.invokeAll(callables);
        for (var future : futures) {
            future.get();
        }
        System.out.println(synchronizedExample.value);
        System.out.println(methodExecutionTimeProxy.getTotalExecutionTime());

        synchronizedExample.syncValue = 0;
        methodExecutionTimeProxy.setTotalExecutionTime(0);

        callables = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            callables.add(() -> {
                proxy.incrementValueSync();
                return null;
            });
        }
        futures = executorService.invokeAll(callables);
        for (var future : futures) {
            future.get();
        }
        System.out.println(synchronizedExample.syncValue);
        System.out.println(methodExecutionTimeProxy.getTotalExecutionTime());


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        //Как получить jvm error
        /*while (true) {
            synchronizedExample.doSomething();
            if (synchronizedExample.value < 1) {
                break;
            }
        }*/
        /*List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }*/

    }
}

