package ru.starkov.thread_congention;

public class ThreadCongestion {
    private static final int NUM_THREADS = 5;
    private static final int ITERATIONS_PER_THREAD = 10;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isVirtual());
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
                    doSomeWork();
                }
            });
            thread.start();
        }
    }

    private static void doSomeWork() {
        double result = 0;
        for (int i = 0; i < 100000; i++) {
            result += Math.sqrt(i) * Math.pow(i, 2);
            System.out.println(result + " на итерации " + i);
        }
    }

}
