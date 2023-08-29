/**
 * @author BOOM
 * @create 2023-07-26 11:14
 */
package com.hhl.test.cas;

/**
 @author boom
 @create 2023-07-26 11:14
 */
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
    private static LongAdder counter = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        int iterations = 10000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        new Thread(() -> {
            for(int i=0; i<100; i++){
                System.out.println(counter.intValue());
            }
        }).start();

        // 等待所有线程执行完毕
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

        // 输出计数结果
        System.out.println("Final Count: " + counter.sum());
    }
}
