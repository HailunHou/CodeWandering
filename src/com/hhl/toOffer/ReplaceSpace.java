/**
 * @author BOOM
 * @create 2023-09-01 10:24
 */
package com.hhl.toOffer;

/**
 @author boom
 @create 2023-09-01 10:24
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s  = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }

    public static String replaceSpace(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == ' '){
                sb.replace(i, i+1, "%20");
            }
        }
        return sb.toString();
    }
}
