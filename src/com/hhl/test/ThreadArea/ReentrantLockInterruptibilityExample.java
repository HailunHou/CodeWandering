/**
 * @author BOOM
 * @create 2023-08-31 15:42
 */
package com.hhl.test.ThreadArea;

/**
 @author boom
 @create 2023-08-31 15:42
 */
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


// 手动创建线程版
/**
 * 使用lockInterruptibly()方法获取锁时可响应中断，当中断时，会抛出异常并放弃获取当前锁。
 * 使用lock()方法获取锁时，不响应中断，当中断时，只会被唤醒并尝试获取锁，获取失败后再次挂起。
 */
public class ReentrantLockInterruptibilityExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
//                lock.lock();
                System.out.println("Thread 1 acquired the lock.");
                Thread.sleep(3000); // Simulating some work
            } catch (InterruptedException e) {
                System.out.println("Thread 1 was interrupted while waiting for the lock.");
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread 2 acquired the lock.");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("t2 unlock");
                lock.unlock();
            }
        });

        t2.start();

        // Let Thread 1 start waiting for the lock
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();

        // Interrupt Thread 1 while it's waiting for the lock
        System.out.println("Thread 1 ready to interrupt");
        t1.interrupt();
    }
}
