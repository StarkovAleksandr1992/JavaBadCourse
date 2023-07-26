package ru.starkov.example;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static class Parent {
        private static int count = 0;
        public int id;
        public Parent() {
            this.id = ++count;
        }

        public static void doSomething(List<? extends Parent> parents) {
            parents.forEach(System.out::println);
        }

        @Override
        public String toString() {
            return "Parent{" +
                    "id=" + id +
                    '}';
        }
    }

    public static class Child extends Parent {
        private static int count = 0;
        public int id;

        Child() {
            this.id = ++count;
        }

        @Override
        public String toString() {
            return "Child{" +
                    "id=" + id +
                    '}';
        }
    }

    public static void main(String[] args) {
        Child child1 = new Child();
        Child child2 = new Child();
        List<Child> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        Parent parent1 = new Parent();
        Parent parent2 = new Parent();
        List<Parent> parents = new ArrayList<>();
        parents.add(parent1);
        parents.add(parent2);
        Example.Parent.doSomething(parents);
        Example.Parent.doSomething(children);

    }
}
