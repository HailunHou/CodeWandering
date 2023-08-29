/**
 * @author BOOM
 * @create 2023-07-14 17:01
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-14 17:01
 */
public class F {
    private String name = "F";
    private int age = 30;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

class S extends F{
    String name = "S";

    public static void main(String[] args) {
        F s = new S();
        s.setName("X");
        System.out.println("s.getName() = " + s.getName());
//        System.out.println("s.name = " + s.name);
    }

    public String getName() {
        System.out.println("super.getName() = " + super.getName());
        return name;
    }

}


