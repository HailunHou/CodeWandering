/**
 * @author BOOM
 * @create 2023-07-27 19:21
 */
package com.hhl.test;

import sun.misc.PostVMInitHook;

/**
 @author boom
 @create 2023-07-27 19:21
 */
public class Test extends Father{
    private String name="test";
    public static void main(String[] args){
    Test test=new Test();
System.out.println(test.getName());
}
}
class Father{
        private String name="father";
        public String getName(){
    return name;
}
}

