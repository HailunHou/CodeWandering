/**
 * @author BOOM
 * @create 2023-07-26 21:38
 */
package com.hhl.test.futureTask;

import com.hhl.test.F;
import com.sun.org.apache.xpath.internal.functions.FuncTranslate;
import sun.misc.PostVMInitHook;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-07-26 21:38
 */
public class Demo1 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask1 = new FutureTask<>(() -> {
            System.out.println("1 in");
            TimeUnit.SECONDS.sleep(3);
            return 1;
        });

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println("2 in");
            TimeUnit.SECONDS.sleep(6);
            return 2;
        });

        try {
            new Thread(futureTask1, "task1").start();
            new Thread(futureTask2, "task2").start();
            System.out.println(futureTask1.get());
            System.out.println(futureTask2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main over");
    }
}
