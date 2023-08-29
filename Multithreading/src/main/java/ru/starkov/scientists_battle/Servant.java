package ru.starkov.scientists_battle;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class Servant implements Callable<HashMap<Parts, Integer>> {

    private GarbageDump garbageDump;
    private Scientist scientist;

    public Servant(GarbageDump garbageDump, Scientist scientist) {
        this.garbageDump = garbageDump;
        this.scientist = scientist;
    }

    public void setGarbageDump(GarbageDump garbageDump) {
        this.garbageDump = garbageDump;
    }

    @Override
    public HashMap<Parts, Integer> call() {
        HashMap<Parts, Integer> mastersOrder = new HashMap<>();
        Random random = new Random();
        ConcurrentHashMap<Parts, Integer> garbageDumpParts = garbageDump.getParts();
        int numberOfParts = random.nextInt(1,5);
        for (int i = 0; i < numberOfParts; i++) {
            Parts part = Parts.values()[(random.nextInt(0, Parts.values().length))];
            if (garbageDumpParts.get(part) >= 1) {
                mastersOrder.putIfAbsent(part, 0);
                mastersOrder.computeIfPresent(part, (currentPart, count) -> count + 1);
                garbageDumpParts.compute(part, (currentPart, count) -> count - 1);
            }
        }
        return mastersOrder;
    }
}
