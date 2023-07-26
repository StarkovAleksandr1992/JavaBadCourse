package ru.starkov.scientists_battle;

import java.util.Random;

public class Fabric {

    public Fabric() {
    }

    public void produceGarbage(int numberOfTheNight) {
        if (numberOfTheNight < 1) {
            throw new IllegalArgumentException("Счет ночей должен начинаться с 1");
        }
        Random random = new Random();
        Parts[] values = Parts.values();
        int numberOfParts;
        if (numberOfTheNight == 1) {
            numberOfParts = 20;
            for (int i = 0; i < numberOfParts; i++) {
                Parts part = values[random.nextInt(values.length)];
                GarbageDump.garbage.computeIfPresent(part, (currentPart, count) -> count + 1);
            }
        } else {
            numberOfParts = random.nextInt(1, 5);
            for (int i = 0; i < numberOfParts; i++) {
                Parts part = values[random.nextInt(values.length)];
                GarbageDump.garbage.computeIfPresent(part, (currentPart, count) -> count + 1);
            }
        }
    }
}
