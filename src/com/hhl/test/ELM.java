/**
 * @author BOOM
 * @create 2023-08-17 19:52
 */
package com.hhl.test;

import java.util.*;

/**
 @author boom
 @create 2023-08-17 19:52
 */
public class ELM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<chars.length; i++){
            set.add(chars[i]);
        }
        //字符集
        Object[] eng = set.toArray();
        List<Character> list = new ArrayList<>(26);
        for (int i = 0; i < eng.length; i++) {
            list.add((Character) eng[i]);
        }

        char[] newChars = new char[chars.length];
        for(int i=0; i<chars.length; i++){
            newChars[i] = list.get((list.indexOf(chars[i])+1)%(list.size()));
        }
        String res = new String(newChars);
        System.out.println(res);
    }
}
