/**
 * @author BOOM
 * @create 2023-08-25 21:54
 */
package com.hhl.test.ThreadArea;

import lombok.Synchronized;
import org.junit.internal.runners.statements.RunAfters;

/**
 @author boom
 @create 2023-08-25 21:54
 */
public class Test1 {


    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }

}

class Task implements Runnable{
    Object object = new Object();
    static int count = 0;
    @Override
    public void run() {
        synchronized(object){
            try {
                if(count == 1){
                    object.notify();
                }
                System.out.println("开始等待2s");
                count++;
                object.wait(2000);
                System.out.println("2s到了");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



