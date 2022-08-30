/**
 * @author BOOM
 * @create 2022-08-30 9:15
 */
package com.hhl.string;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] strs = s.toCharArray();
        for (int i = 0; i < s.length(); i+=2*k) {
                int left = i;
                int right = Math.min(i+k-1, s.length()-1);
                while (left < right) {
                    char temp = strs[left];
                    strs[left] = strs[right];
                    strs[right] = temp;
                    right--;
                    left++;
                }
            }
        return new String(strs);
    }
}
