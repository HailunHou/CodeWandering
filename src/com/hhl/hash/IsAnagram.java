/**
 * @author BOOM
 * @create 2022-08-20 10:26
 */
package com.hhl.hash;

import java.util.Arrays;

/**
 * 有效的字母异位词
 */
public class IsAnagram {
    /**
     * 代码随想录标准答案
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 自己写的
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_1(String s, String t) {
        int[] cHash = new int[26];
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        while (--sl >= 0) {
            cHash[(int) (s.charAt(sl) - 'a')]++;
        }
        while (--tl >= 0) {
            cHash[(int) (t.charAt(tl) - 'a')]--;
        }
        for (int i = 0; i < cHash.length; i++) {
            if (cHash[i] > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 力扣优化版本
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_2(String s, String t) {
        int[] cHash = new int[26];
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        while (--sl >= 0) {
            cHash[(int) (s.charAt(sl) - 'a')]++;
            cHash[(int) (t.charAt(sl) - 'a')]--;
        }
        for (int i = 0; i < cHash.length; i++) {
            if (cHash[i] > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 力扣官方版
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
