/**
 * @author BOOM
 * @create 2023-09-01 10:29
 */
package com.hhl.toOffer;

/**
 @author boom
 @create 2023-09-01 10:29
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseLeftWords(s, k);
        System.out.println(s1);
    }

    public static String reverseLeftWords(String s, int n){
        char[] chars = s.toCharArray();
        int len = chars.length;
        revese(chars, 0, n);
        revese(chars, n, len);
        revese(chars, 0, len);
        return new String(chars);
    }

    public static void revese(char[] chs, int left, int right){
        int l = left;
        int r = right-1;
        char temp = 0;
        while(l < r){
            temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++;
            r--;
        }
    }
}
