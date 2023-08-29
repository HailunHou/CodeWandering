/**
 * @author BOOM
 * @create 2023-07-25 10:07
 */
package com.hhl.test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author boom
 * @create 2023-07-25 10:07
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        System.out.println(threadPoolExecutor.getActiveCount());
        try{
            for(int i=0; i<100; i++){
//                System.out.print(i);
                threadPoolExecutor.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-ok");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
