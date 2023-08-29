/**
 * @author BOOM
 * @create 2023-07-27 9:33
 */
package com.hhl.test.ThreadPool;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-07-27 9:33
 */
public class addWorkerTest {


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
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务一");
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务二，耗时任务，执行中");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("任务二执行完成");
            }
        };

        try {
            threadPoolExecutor.execute(r1);
            System.out.println("线程池线程数量1：" + threadPoolExecutor.getPoolSize());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("线程池线程数量2：" + threadPoolExecutor.getPoolSize());
            threadPoolExecutor.execute(r2);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("线程池线程数量2：" + threadPoolExecutor.getPoolSize());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

}
