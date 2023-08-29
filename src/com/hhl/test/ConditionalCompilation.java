/**
 * @author BOOM
 * @create 2023-05-23 16:34
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-05-23 16:34
 */
public class ConditionalCompilation {
    public static void main(String[] args) {
        final boolean DEBUG = true;
        if(DEBUG) {
            System.out.println("Hello, DEBUG!");
        }

        final boolean ONLINE = false;

        if(ONLINE){
            System.out.println("Hello, ONLINE!");
        }
    }
}
