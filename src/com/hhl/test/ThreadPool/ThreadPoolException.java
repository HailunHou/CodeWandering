/**
 * @author BOOM
 * @create 2023-08-17 16:54
 */
package com.hhl.test.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-08-17 16:54
 */
public class ThreadPoolException {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        Runnable r = () -> {
            int a = 1/0;
        };
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(r);
        }
    }
}
