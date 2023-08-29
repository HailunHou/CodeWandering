/**
 * @author BOOM
 * @create 2023-07-27 17:19
 */
package com.hhl.test.CountDownLatch;

/**
 @author boom
 @create 2023-07-27 17:19
 */
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 5; // 设置线程数量

        CountDownLatch latch = new CountDownLatch(nThreads); // 初始化 CountDownLatch，计数器初始值为 nThreads

        // 创建 nThreads 个线程并启动
        for (int i = 1; i <= nThreads; i++) {
            Thread thread = new Thread(new Worker(i, latch));
            thread.start();
        }

        // 等待所有线程执行完毕
        latch.await();

        // 所有线程执行完毕后，主线程继续执行
        System.out.println("All workers have completed their tasks.");
    }
}

class Worker implements Runnable {
    private final int workerId;
    private final CountDownLatch latch;

    public Worker(int workerId, CountDownLatch latch) {
        this.workerId = workerId;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + workerId + " is doing its task...");
        try {
            Thread.sleep(2000); // 模拟任务执行耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + workerId + " has completed its task.");
        latch.countDown(); // 任务执行完毕，计数器减1
    }
}
