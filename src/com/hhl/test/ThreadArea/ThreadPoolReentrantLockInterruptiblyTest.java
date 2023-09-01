/**
 * @author BOOM
 * @create 2023-08-31 15:50
 */
package com.hhl.test.ThreadArea;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 @author boom
 @create 2023-08-31 15:50
 */

// 线程池版
/**
 * 无论使用lockInterruptibly()还是lock()方法，在线程池调用shutdownNow()后都会响应中断并抛出异常。
 */
public class ThreadPoolReentrantLockInterruptiblyTest {
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    lock.lockInterruptibly();
//                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取可中断锁");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "被中断了");
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                    lock.unlock();
                }
            });
        }

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        threadPoolExecutor.shutdownNow();
    }
}
