/**
 * @author BOOM
 * @create 2023-08-26 20:01
 */
package com.hhl.test.XD;

/**
 @author boom
 @create 2023-08-26 20:01
 */
public class Example{
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]){
        str = "hello";
        ch[0]='x';
    }
}
