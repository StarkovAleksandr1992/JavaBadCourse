package ru.starkov;

import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        System.out.println(b.i);
        System.out.println(b.j);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("..\\..\\..\\TestDirectory\\file.bin"))) {
            outputStream.writeObject(b);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("..\\..\\..\\TestDirectory\\file.bin"))) {
            B object = (B) inputStream.readObject();
            System.out.println(b.i);
            System.out.println(b.j);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class A {
        int i = 10;

        public A() {
            i = 15;
        }
    }

    public static class B extends A implements Externalizable {
        transient String j = "123";

        public B() {

            j = "opa";
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            j = "aga";
            out.writeObject(this);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            in.readObject();
        }
    }
}