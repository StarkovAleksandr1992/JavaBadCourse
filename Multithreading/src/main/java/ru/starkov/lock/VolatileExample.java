package ru.starkov.lock;

public class VolatileExample {

    volatile int x;
    volatile int y;

    volatile int a;
    volatile int b;

    private void assign1() {
        this.x = 1;
        this.y = 2;
    }

    private void assign2() {
        a = x;
        b = y;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();
        Thread thread1 = new Thread(volatileExample::assign1);
        Thread thread2 = new Thread(volatileExample::assign2);
        thread1.start();
        thread2.start();
        //Если мы не объявим поля x, y, a, b как volatile, то можем словить бесконечный цикл
        while (volatileExample.a != 1 && volatileExample.b != 2) {
            System.out.println(1);
        }
        System.out.printf("x = %d, y = %d, a = %d, b = %d\n", volatileExample.x, volatileExample.y, volatileExample.a, volatileExample.b);
    }

}
