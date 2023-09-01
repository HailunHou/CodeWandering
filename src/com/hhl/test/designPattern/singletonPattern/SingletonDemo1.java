/**
 * @author BOOM
 * @create 2023-08-31 15:05
 */
package com.hhl.test.designPattern.singletonPattern;

/**
 @author boom
 @create 2023-08-31 15:05
 */
// 懒汉式1 双重校验锁
public class SingletonDemo1 {
    private SingletonDemo1(){
        if(obj != null){
            throw new RuntimeException("非法操作");
        }
    }
    private static volatile SingletonDemo1 obj;

    public static SingletonDemo1 getObject(){
        if(obj == null){
            synchronized (SingletonDemo1.class){
                if(obj == null){
                    obj = new SingletonDemo1();
                }
            }
        }
        return obj;
    }
}
