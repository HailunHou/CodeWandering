/**
 * @author BOOM
 * @create 2023-04-04 21:49
 */
package com.hhl.test;

import com.hhl.hash.Intersection;
import com.hhl.utils.ArrayUtils;
import jdk.management.resource.ResourceType;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import sun.awt.windows.ThemeReader;
import sun.security.util.ArrayUtil;

import java.beans.IntrospectionException;
import java.io.*;
import java.net.Inet4Address;
import java.time.Year;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

/**
 * @author boom
 * @create 2023-04-04 21:49
 */

public class TestArea {

    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[59];
            dp[2] = 1;
            dp[3] = 2;
            for(int i=4; i<=n; i++){
                int max = 0;
                for(int j=1; j<=i/2; j++){
                    max = Math.max(max, Math.max(j*dp[i-j], j*(i-j)));
                }
                dp[i] = max;
            }
            return dp[n];
        }
    }

    @Test
    public void test1() {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[75776*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }

    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer("12345");
        sb.delete(sb.length() - 3, sb.length());
        System.out.println("sb.toString() = " + sb.toString());
        String s = "123";
        s.startsWith("");
    }

    @Test
    public void test3() {
        int a = Integer.MIN_VALUE;
        int[] as = new int[]{1, 2, 3, 4, 5, 6};
        int[] ints = Arrays.copyOfRange(as, 3, 7);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    public void test4() {
        Deque<Integer> deque = new ArrayDeque<>();

        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("1");
        strList.add("1");

        strList.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    public void test5() {
        try (Writer output = new FileWriter("output.txt")) {
            output.write("你好，我是那个谁！！！", 3, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟HashMap中tableSizeFor函数
     */
    @Test
    public void test6() {
        final int MAXIMUM_CAPACITY = 1 << 30;
        int cap = 19;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int res = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println("res = " + res);
    }

    @Test
    public void test7(){
        int a = (int) Math.pow(2, 4);
        System.out.println("a = " + a);
        int b = 3;
        int c = b%a;
        int d = (a-1) & b;
        System.out.println(c == d);
    }

    @Test
    public void test8(){
        Solution solution = new Solution();
        int integerBreak = solution.integerBreak(9);
        System.out.println("integerBreak = " + integerBreak);
    }

    @Test
    public void test9(){
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(3,3);
        map.put(2,3);

    }

    @Test
    public void test10(){
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = "abc";
        String s4 = s2.intern();
        String s5 = s3.intern();
        System.out.println("s1 == s1.intern() = " + (s1 == s1.intern()));
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s4 == s5);

    }

    @Test
    public void test11() throws InterruptedException {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                2,
//                5,
//                0L,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
        Thread t1 = new Thread(){
          public void run(){
              System.out.println(Thread.currentThread().getName() + "启动...");
              System.out.println("执行park");
              LockSupport.park();
              System.out.println("有线程执行了unpark");
          }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName() + "启动...");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LockSupport.unpark(t1);
                System.out.println("执行unpark(t1)");
            }
        };
        t2.start();

        t1.join();
        System.out.println("Main method terminate");

    }

    @Test
    public void test12() throws InterruptedException {

        Thread t1 = new Thread(){
            public void run(){
                try {
                    Thread.currentThread().wait();
//                    wait();
                    System.out.println(Thread.currentThread().getName() + " Over");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                try {
                    Thread.sleep(1000);
                    notify();
                    System.out.println(Thread.currentThread().getName() + " Over");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t2.start();

        t1.join();
        System.out.println("Main method terminate");

    }

    @Test
    public void test13(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                20,
                100,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory()
        );
//        List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<100; i++){
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                list.add(new Integer(finalI));
                System.out.println(list);
            });
        }
    }

    @Test
    public void test14(){
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "获取到a");
                System.out.println(Thread.currentThread().getName() + "正在获取b");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获取到b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "获取到a");
                System.out.println(Thread.currentThread().getName() + "正在获取b");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获取到b");
                }
            }
        }, "B").start();
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "获取到a");
                System.out.println(Thread.currentThread().getName() + "正在获取b");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获取到b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "获取到a");
                System.out.println(Thread.currentThread().getName() + "正在获取b");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获取到b");
                }
            }
        }, "B").start();
    }

    @Test
    public void test15(){
            String s1 = "abc";
            String s2 = new String("abc");
            System.out.println(s1==s2);
            s2.intern();
            System.out.println(s1==s2);
    }


}
