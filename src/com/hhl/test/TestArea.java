package com.hhl.test;

import org.junit.Test;

import java.util.*;

class Solution {
    public String removeDuplicates(String s) {
         Stack<Character> stack = new Stack<>();
//        Queue<Character> queue = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.empty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        StringBuilder ss = new StringBuilder();

        StringBuffer sb = new StringBuffer();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return new String(sb.reverse());
    }
}
public class TestArea {
    @Test
    public void test1(){

    }

    @Test
    public void test2(){
        String a = "123";
        char[] chars = a.toCharArray();
        String s = new String(chars);
//        System.out.println(s.equals(a));
        System.out.println("s = " + s);
        System.out.println("a = " + a);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String abbaca = solution.removeDuplicates("abbaca");
        System.out.println(abbaca);
    }

    @Test
    public void test4(){
        Stack<String> stack = new Stack<>();
        char c = 'a';
        stack.push(new String(c+""));
        System.out.println(new String(""+c));
        String a=null;
        
    }



}
