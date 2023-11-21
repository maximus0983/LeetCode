package leet.task1115;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    Semaphore sem = new Semaphore(1);
    Semaphore sem1 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sem1.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sem.release(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
        fooBar.bar(() -> System.out.println("bar"));
        fooBar.foo(()-> System.out.print("foo"));
    }
}
