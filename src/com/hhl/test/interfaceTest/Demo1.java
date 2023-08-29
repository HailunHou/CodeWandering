/**
 * @author BOOM
 * @create 2023-08-29 20:56
 */
package com.hhl.test.interfaceTest;

/**
 @author boom
 @create 2023-08-29 20:56
 */

/**
 * 接口的静态方法只能使用类名的方式调用。实现了接口的类无法调用接口的静态方法，
 * 但是可以创建对象，调用接口的默认方法。
 */
public class Demo1 implements InterfaceDemo1{
    public static void main(String[] args) {
        InterfaceDemo1.print();
        System.out.println("main");
        EnumDemo1.print();
        InterfaceDemo1 interfaceDemo1 = new InterfaceDemo1() {

        };
        interfaceDemo1.play();
    }
}
