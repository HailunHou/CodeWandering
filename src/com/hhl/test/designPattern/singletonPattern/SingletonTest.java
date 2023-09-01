/**
 * @author BOOM
 * @create 2023-08-31 15:28
 */
package com.hhl.test.designPattern.singletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 @author boom
 @create 2023-08-31 15:28
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonDemo4 object1 = SingletonDemo4.getObject();
        SingletonDemo4 object2 = SingletonDemo4.getObject();
        System.out.println("object1 = " + object1);
        System.out.println("object2 = " + object2);
        System.out.println("object1==object2 = " + (object1 == object2));
        Class<?> clazz = SingletonDemo4.class;
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            SingletonDemo4 newObj = (SingletonDemo4)declaredConstructor.newInstance(null);
            System.out.println("newObj = " + newObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
