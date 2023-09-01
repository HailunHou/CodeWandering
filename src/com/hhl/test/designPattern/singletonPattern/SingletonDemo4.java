/**
 * @author BOOM
 * @create 2023-08-31 15:26
 */
package com.hhl.test.designPattern.singletonPattern;

/**
 @author boom
 @create 2023-08-31 15:26
 */
// 饿汉式
public class SingletonDemo4 {
    private SingletonDemo4(){
        if(obj != null){
            throw new RuntimeException("非法操作");
        }
    }
    private static final SingletonDemo4 obj = new SingletonDemo4();

    public static SingletonDemo4 getObject(){
        return obj;
    }
}
