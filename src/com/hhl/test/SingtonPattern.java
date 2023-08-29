/**
 * @author BOOM
 * @create 2023-08-17 20:52
 */
package com.hhl.test;

import lombok.Synchronized;

/**
 @author boom
 @create 2023-08-17 20:52
 */
public class SingtonPattern {
    private static volatile SingtonPattern singtonPattern;
    private SingtonPattern(){

    }

    public static SingtonPattern newInstance(){
        if(singtonPattern == null){
            synchronized(SingtonPattern.class){
                if(singtonPattern == null){
                    singtonPattern = new SingtonPattern();
                }
            }
        }
        return singtonPattern;
    }
}
