package ru.starkov.scientists_battle;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battle {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        GarbageDump garbageDump = GarbageDump.getInstance();
        Fabric fabric = new Fabric();
        fabric.produceGarbage(1);
        Scientist scientist1 = new Scientist();
        Servant servant1 = new Servant(garbageDump, scientist1);
        Scientist scientist2 = new Scientist();
        Servant servant2 = new Servant(garbageDump, scientist2);
        scientist1.setServant(servant1);
        scientist2.setServant(servant2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 100; i++) {
            fabric.produceGarbage(i);

            CompletableFuture<Void> task1 = CompletableFuture.runAsync(scientist1, executor);
            CompletableFuture<Void> task2 = CompletableFuture.runAsync(scientist2, executor);

            Thread.sleep(10);

            CompletableFuture.allOf(task1, task2).join();
        }

        executor.shutdown();

        String message = scientist1.getNumberOfRobots() == scientist2.getNumberOfRobots()
                ? "Победила дружба, оба собрали по " + scientist1.getNumberOfRobots() + " роботов"
                : scientist1.getNumberOfRobots() > scientist2.getNumberOfRobots()
                ? "Победил ученый № 1, он собрал " + scientist1.getNumberOfRobots() + " роботов"
                : "Победил ученый № 2, он собрал " + scientist2.getNumberOfRobots() + " роботов";
        System.out.println(message);
    }
}
