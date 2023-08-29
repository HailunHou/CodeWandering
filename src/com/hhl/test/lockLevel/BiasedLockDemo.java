/**
 * @author BOOM
 * @create 2023-07-26 15:30
 */
package com.hhl.test.lockLevel;

/**
 @author boom
 @create 2023-07-26 15:30
 */
public class BiasedLockDemo {
    static int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        BiasedLockDemo obj = new BiasedLockDemo();
        // 预热
        for (int i = 0; i < 10000000; i++) {
            obj.increment();
        }
        long start = System.currentTimeMillis();
        // 竞争同一个偏向锁
        synchronized (obj) {
            for (long i = 0; i < 1000000000L; i++) {
                obj.increment();
            }
        }
        long end = System.currentTimeMillis();
        // time: 55650, counter: 1010000000
        System.out.println("time: " + (end - start) + ", counter: " + counter);
    }
}
