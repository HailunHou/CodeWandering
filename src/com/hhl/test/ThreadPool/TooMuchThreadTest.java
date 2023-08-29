/**
 * @author BOOM
 * @create 2023-08-02 14:00
 */
package com.hhl.test.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author boom
 @create 2023-08-02 14:00
 */
public class TooMuchThreadTest {
    volatile static int i = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(i=0; i<2100000000; i++){
            executorService.execute(() -> {
                System.out.println(i);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            });
        }
//        new Thread(() -> {
//            for(;;){
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                    System.out.println(i);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
    }

}
