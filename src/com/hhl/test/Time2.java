/**
 * @author BOOM
 * @create 2023-08-29 10:35
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-29 10:35
 */
class Outer {
    static int a = 0;
    class Inner {
        int a = 1;

        void function() {
            int a = 2;
            System.out.println("a = " + a);
        }
    }
}

public class Time2 {
    public static void main(String[] args) {
        Outer.Inner innerObj = new Outer().new Inner();
        innerObj.function();
    }
}