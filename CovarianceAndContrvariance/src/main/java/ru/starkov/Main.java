package ru.starkov;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Citrus citrus = new Citrus(3);
        Orange orange = new Orange(1, 10);
        BigRoundOrange bigRoundOrange = new BigRoundOrange(2, 20);
        Fruit fruit = new Fruit(14);
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(citrus);
        fruits.add(orange);
        fruits.add(fruit);
        fruits.add(bigRoundOrange);
        System.out.println(getWeight(fruits));
        addOranges(fruits);
    }

    public static enum A {
        Foo,
        Bar,
        Baz
    }
    private static class Obj implements Comparable<Obj> {
        private int i;

        public Obj(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Obj o) {
            return Integer.compare(this.i - o.i, 0);
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "i=" + i +
                    '}';
        }
    }
    //Пример ковариантности типов
    public static int getWeight(List<? extends Fruit> fruits) {
        int sum = fruits.stream().mapToInt(f -> f.weight).sum();
        return sum;
    }

    // Пример контрвариантности.
    public static void addOranges(List<? super Orange> fruits) {
        fruits.add(new Orange(1, 10));
        fruits.add(new BigRoundOrange(1, 3));
    }


}