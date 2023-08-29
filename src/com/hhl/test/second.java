/**
 * @author BOOM
 * @create 2023-08-17 20:15
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-17 20:15
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class second{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        Set<String> r_set = new HashSet<>(); //初始字符集
        Set<String> s_set = new HashSet<>(); //已用字符集
        char[] aa = a.toCharArray();
        for(char t : aa){
            r_set.add(t+"");
        }
        if(r_set.size() == 1){
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(char t : aa){
            Set<String> temp_set = new HashSet<>(r_set);
            temp_set.remove(t+"");
            temp_set.removeAll(s_set);
            if(temp_set.size() != 0){
                String st = new ArrayList<String>(temp_set).get(0);
                sb.append(st);
                s_set.add(st);
            }
            else{
                temp_set = new HashSet<>(s_set);
                temp_set.remove(t+"");
                sb.append(new ArrayList<String>(temp_set).get(0));
            }
        }
        System.out.println(sb.toString());
    }
}