package ru.starkov.find_max;

import java.util.Arrays;
import java.util.Random;

public class FindMax {

    public static void main(String[] args) {
        int[] ints = randomInts();
        long start = System.currentTimeMillis();
        int maxBySingleThread = findMaxBySingleThread(ints);
        long end = System.currentTimeMillis();
        System.out.printf("Максимальное число равно = %d, найдено одним потоком за %d мс \n", maxBySingleThread, end - start);
        start = System.currentTimeMillis();
        int maxByMultiThreads = findMaxByMultiThreads(ints);
        end = System.currentTimeMillis();
        System.out.printf("Максимальное число равно = %d, найдено несколькими потоками за %d мс\n", maxByMultiThreads, end - start);


    }

    public static int findMaxBySingleThread(int[] ints) {
        int max = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        return max;
    }

    public static int findMaxByMultiThreads(int[] ints) {
        return Arrays.stream(ints).parallel().max().getAsInt();
    }

    public static int[] randomInts() {
        Random random = new Random();
        int length = random.nextInt(1_000_000) + 1;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = random.nextInt(300);
        }
        return ints;
    }
}
