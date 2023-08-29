/**
 * @author BOOM
 * @create 2023-08-28 21:58
 */
package com.hhl.test.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-08-28 21:58
 */
public class TheadPoolShutDown {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        for (int i = 0; i < 12; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threadPoolExecutor.shutdown();

        for (int i = 0; i < 10000; i++) {
            System.out.println(threadPoolExecutor.isTerminated());
        }
    }
}
