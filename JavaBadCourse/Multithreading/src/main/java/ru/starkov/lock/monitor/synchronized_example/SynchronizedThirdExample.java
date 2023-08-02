package ru.starkov.lock.monitor.synchronized_example;

public class SynchronizedThirdExample {
    private static int i = 0;
    private static  void incrementI() {
        System.out.println(++i);
        System.out.println("i am Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedThirdExample::incrementI);
        Thread thread2 = new Thread(SynchronizedThirdExample::incrementI);
        thread1.start();
        thread2.start();
    }

}
