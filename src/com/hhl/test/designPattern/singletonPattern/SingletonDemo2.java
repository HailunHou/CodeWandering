/**
 * @author BOOM
 * @create 2023-08-31 15:09
 */
package com.hhl.test.designPattern.singletonPattern;

/**
 @author boom
 @create 2023-08-31 15:09
 */
// 懒汉式2 静态内部类
// 原理是什么？
public class SingletonDemo2 {
    private SingletonDemo2(){
        if(INNER.obj != null){
            throw new RuntimeException("非法操作");
        }
    }

    public static SingletonDemo2 getObject(){
        return INNER.obj;
    }

    private static class INNER{
        private static final SingletonDemo2 obj = new SingletonDemo2();
    }

}
