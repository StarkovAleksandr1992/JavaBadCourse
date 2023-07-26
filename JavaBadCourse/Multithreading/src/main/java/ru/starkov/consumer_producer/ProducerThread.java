package ru.starkov.consumer_producer;

import java.util.List;
import java.util.Random;

public class ProducerThread extends Thread {

    private final List<Integer> integers;

    public ProducerThread(List<Integer> integers) {
        super();
        this.integers = integers;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (integers) {

            while (true) {
                try {
                    integers.wait(random.nextLong(600));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (integers.size() < 10) {
                    int i = random.nextInt(20);
                    integers.add(i);
                    int size = integers.size();
                    System.out.println("Поток " + getName() + " добавил в список число: " + i + "\n" +
                            "количество чисел в списке: " + size);
                } else {
                    integers.notifyAll();
                }
            }
        }

    }
}
