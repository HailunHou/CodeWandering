/**
 * @author BOOM
 * @create 2022-08-29 22:04
 */
package com.hhl.string;

public class ReverseString {
    /**
     * 代码随想录标准答案：双指针法
     * 使用位运算交换字符
     * @param s
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }

    /**
     * 自己写的
     * 双指针法
     * @param s
     */
    public void reverseString_1(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
