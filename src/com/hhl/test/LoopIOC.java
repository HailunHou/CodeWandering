/**
 * @author BOOM
 * @create 2023-08-14 20:39
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-14 20:39
 */
public class LoopIOC {
    public static void main(String[] args) {

        A a = new A();

    }
}

class A{
    public A() {
        new B();
    }
}

class B{
    public B() {
        new A();
    }
}
