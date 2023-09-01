/**
 * @author BOOM
 * @create 2023-08-31 9:58
 */
package com.hhl.test.ThreadArea;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 @author boom
 @create 2023-08-31 9:58
 */
public class Test2 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

    }
}

class MCondition{
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition1;
    Condition condition2;
    public MCondition() {
        condition1 = reentrantLock.newCondition();
        condition2 = reentrantLock.newCondition();
    }
    public void synFunc() throws InterruptedException {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + "条件挂起...");
        condition1.await();

    }
}
