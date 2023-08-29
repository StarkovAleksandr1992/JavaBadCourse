package ru.starkov.consumer_producer;

import java.util.List;

public class ConsumerThread extends Thread {
    private final List<Integer> integers;

    public ConsumerThread(List<Integer> integers) {
        super();
        this.integers = integers;
    }

    @Override
    public void run() {
        synchronized (integers) {

            while (true) {
                try {
                    integers.wait(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (!integers.isEmpty()) {
                    int size = integers.size();
                    System.out.println("Поток: " + getName() + " получил число: " + integers.remove(0) + " из списка размером: " + size);
                }
            }
        }
    }
}
