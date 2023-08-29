/**
 * @author BOOM
 * @create 2023-08-29 10:29
 */
package com.hhl.test;

import java.lang.reflect.Field;

/**
 @author boom
 @create 2023-08-29 10:29
 */
public class Time1 {
    public static void main(String[] args) throws InterruptedException {
        Field[] declaredMethods = Student.class.getFields();
        for (Field declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }

    class Student {
        String name;
        private int age;
        public String sid;
        protected String phone;
    }
}
