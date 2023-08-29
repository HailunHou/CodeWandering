/**
 * @author BOOM
 * @create 2023-08-17 21:22
 */
package com.hhl.test.ThreadPool;

import java.util.concurrent.*;

/**
 @author boom
 @create 2023-08-17 21:22
 */
public class RunnableCheckException {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable r = () -> {
            try {
                int res = 1/0;
            }catch (Exception e){
                throw new RuntimeException("这是一个异常");
            }
        };
        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.execute(() ->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "over！");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPoolExecutor.shutdown();
        System.out.println("go");
        for(int i=0; i<1000; i++){
            System.out.println(threadPoolExecutor.isTerminated());
        }
//        Future<String> future = threadPoolExecutor.submit(() ->{
//            TimeUnit.SECONDS.sleep(1);
//            return "result";
//        });
//        String s = null;
//        try {
//            s = future.get(3, TimeUnit.SECONDS);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(s);
    }


}
