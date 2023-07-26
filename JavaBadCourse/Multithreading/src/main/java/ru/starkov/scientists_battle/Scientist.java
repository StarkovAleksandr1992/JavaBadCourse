package ru.starkov.scientists_battle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Scientist implements Runnable {
    private Servant servant;
    private int numberOfRobots;
    private final Map<Parts, Integer> parts = new HashMap<>();

    public Scientist() {
        super();
    }

    public void setServant(Servant servant) {
        this.servant = servant;
    }

    @Override
    public void run() {
        getPartsFromServant();
        createRobot();
    }


    private Robot createRobot() {
        HashSet<Parts> partsHashSet = new HashSet<>();

        for (var entry : parts.entrySet()) {
            if (entry.getValue() >= 1) {
                partsHashSet.add(entry.getKey());
            }
        }
        Robot robot = new Robot(partsHashSet);
        if (robot.isCompleted()) {
            numberOfRobots++;
            for (var entry : parts.entrySet()) {
                parts.compute(entry.getKey(), (currentPart, count) -> count - 1);
            }
            return robot;
        }
        return null;
    }

    private void getPartsFromServant() {
        HashMap<Parts, Integer> partsFromServant = servant.call();
        for (var entry : partsFromServant.entrySet()) {
            Parts currentPart = entry.getKey();
            parts.putIfAbsent(currentPart, 0);
            parts.computeIfPresent(currentPart, (part, count) -> count + 1);
        }
    }

    public int getNumberOfRobots() {
        return numberOfRobots;
    }
}
