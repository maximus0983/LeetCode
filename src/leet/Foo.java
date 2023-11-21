package leet;

import java.util.concurrent.Semaphore;

public class Foo {
    Semaphore sem = new Semaphore(0);
    Semaphore sem1 = new Semaphore(0);
    volatile int counter = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sem1 = new Semaphore(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem1.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
