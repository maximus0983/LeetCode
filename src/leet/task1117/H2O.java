package leet.task1117;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {
//    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    Semaphore semH = new Semaphore(1);
    Semaphore semO = new Semaphore(1);
    private volatile int number;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        number++;
        if (number == 2) {
            semO.release();
            number = 0;
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semH.release(2);
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        Thread o = new Thread(() -> {
            try {
                h2O.oxygen(() -> h2O.print("o"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread o1 = new Thread(() -> {
            try {
                h2O.oxygen(() -> h2O.print("o"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread h1 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> h2O.print("h"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread h2 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> h2O.print("h"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread h3 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> h2O.print("h"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread h4 = new Thread(() -> {
            try {
                h2O.hydrogen(() -> h2O.print("h"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        o.start();
        o1.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }

    public void print(String s) {
        System.out.print(s);
    }
}
