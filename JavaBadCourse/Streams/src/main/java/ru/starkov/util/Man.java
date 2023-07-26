package ru.starkov.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Man {
    private int age;
    public static List<Man> men = new ArrayList<>();
    public static List<Man> liableForMilitaryServiceMans = new ArrayList<>();
    static {
        men.add(new Man(7));
        men.add(new Man(19));
        men.add(new Man(22));
        men.add(new Man(33));
        men.add(new Man(35));
        men.add(new Man(4));
        men.add(new Man(14));
        men.add(new Man(17));
        men.add(new Man(18));
        men.add(new Man(18));
        men.add(new Man(10));
        men.add(new Man(25));
        for (Man man : men) {
            if (man.isLiableForMilitaryService()) {
                liableForMilitaryServiceMans.add(man);
            }
        }
    }

    public Man(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public boolean isLiableForMilitaryService() {
        return this.getAge() >= 18 && this.getAge() <= 27;
    }
}
