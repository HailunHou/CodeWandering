package com.hhl.test.interfaceTest;

/**
 * @author boom
 * @create 2023-08-29 20:53
 */
public interface InterfaceDemo1 {
    static void print(){
        System.out.println("print...");
    }

    default void play(){
        System.out.println("play");
    }

    static void eat(){
        System.out.println("eat");
    }
}
