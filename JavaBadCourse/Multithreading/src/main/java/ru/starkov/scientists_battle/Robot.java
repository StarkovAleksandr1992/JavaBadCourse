package ru.starkov.scientists_battle;

import java.util.HashSet;
import java.util.Objects;

public class Robot {

    private HashSet<Parts> completeRobot;

    public Robot(HashSet<Parts> completeRobot) {
        this.completeRobot = completeRobot;
    }

    public boolean isCompleted() {
        return completeRobot.size() == Parts.values().length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(completeRobot, robot.completeRobot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completeRobot);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "completeRobot=" + completeRobot +
                '}';
    }
}
