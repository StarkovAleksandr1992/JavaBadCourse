package ru.starkov.scientists_battle;

import ru.starkov.util.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class GarbageDump {

    private static volatile GarbageDump instance;
    public static final ConcurrentHashMap<Parts, Integer> garbage = new ConcurrentHashMap<>();

    static {
        for (int i = 0; i < Parts.values().length; i++) {
            garbage.put(Parts.values()[i], 0);
        }
    }

    public static GarbageDump getInstance() {
        GarbageDump localInstance = instance;
        if (localInstance == null) {
            synchronized (GarbageDump.class) {
                if (instance == null) {
                    localInstance = instance = new GarbageDump();
                }
            }
        }
        return localInstance;
    }

    private GarbageDump() {
    }

    public ConcurrentHashMap<Parts, Integer> getParts() {
        return garbage;
    }
}
