/**
 * @author BOOM
 * @create 2023-07-21 16:20
 */
package com.hhl.test;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-07-21 16:20
 */

public class WaitTest {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("获取了锁");
                try {
                    System.out.println("休眠一会儿");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("调用wait..");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("被唤醒");
            }
        }, "A");
        threadA.start();
        Thread threadB = new Thread(()->{
            synchronized (lock) {
                System.out.println("获得了锁");

                System.out.println("叫醒A");
                lock.notify();
            }
        }, "B");
        threadB.start();
    }
}
