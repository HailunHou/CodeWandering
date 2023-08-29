/**
 * @author BOOM
 * @create 2023-07-25 21:38
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-25 21:38
 */
public class Example {
    private static final Object lock = new Object();
    private static boolean isDataReady = false;

    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!isDataReady) {
                    try {
                        lock.wait(); // 等待数据准备
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 处理数据
                System.out.println("Data is ready. Processing data...");
            }
        });

        Thread dataPreparationThread = new Thread(() -> {
            // 模拟数据准备过程
            try {
                System.out.println("data Prepare");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                isDataReady = true;
                lock.notify(); // 唤醒等待的线程
            }
        });

        waitingThread.start();
        dataPreparationThread.start();
    }
}
