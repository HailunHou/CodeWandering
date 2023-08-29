/**
 * @author BOOM
 * @create 2023-07-26 15:30
 */
package com.hhl.test.lockLevel;

/**
 * @author boom
 * @create 2023-07-26 15:30
 */
public class BiasedLockDemo01 {
    static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
//        BiasedLockDemo01 obj = new BiasedLockDemo01();

        for (int i = 0; i < 10000000; i++) {
            BiasedLockDemo01.increment();
        }
        long start = System.currentTimeMillis();
        // 竞争锁
        Thread t = new Thread(() -> {
            for (long i = 0; i < 1000000000L; i++) {
                BiasedLockDemo01.increment();
            }
        });
        t.start();

        t.join();

        long end = System.currentTimeMillis();
        // time: 55650, counter: 1010000000
        System.out.println("time: " + (end - start) + ", counter: " + counter);
    }
}
