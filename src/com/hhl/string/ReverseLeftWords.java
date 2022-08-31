/**
 * @author BOOM
 * @create 2022-08-31 9:45
 */
package com.hhl.string;

public class ReverseLeftWords {
    /**
     * 自己写的
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chs = s.toCharArray();
        char[] temp = new char[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chs[i];
        }
        int k = 0;
        for (int i = 0; i < chs.length; i++) {
            if (i + n < chs.length) {
                chs[i] = chs[i + n];
            } else {
                chs[i] = temp[k++];
            }
        }
        return new String(chs);
    }

    /**
     * LeetCode标准答案
     * 字符串切片法：直接使用java库函数
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * LeetCode标准答案
     * 列表遍历拼接法
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    /**
     * LeetCode标准答案
     * 字符串遍历拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_3(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for (int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

    /**
     * LeetCode标准答案
     * 字符串遍历拼接
     * 但是使用了取余的方法简化了代码
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_3_1(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }

    /**
     * 代码随想录标准答案
     * 为了达到空间复杂度为常数级
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords_4(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        reverseString(stringBuilder, 0, n-1);
        reverseString(stringBuilder, n, s.length()-1);
        reverseString(stringBuilder, 0, s.length()-1);
        return stringBuilder.toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        char temp;
        while (start < end) {
            temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


}
