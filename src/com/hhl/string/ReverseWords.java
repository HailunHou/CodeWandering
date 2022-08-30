/**
 * @author BOOM
 * @create 2022-08-30 20:06
 */
package com.hhl.string;

public class ReverseWords {
    /**
     * 自己写的，虽然通过了，但还是有点稀里糊涂的，需要重新思考一遍
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char chs[] = s.toCharArray();
        reverse(chs, 0, chs.length-1);
        int k = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            int wordStart = i;
            while (i < chs.length && chs[i] != ' ') {
                i++;
            }
            reverse(chs, wordStart, i-1);
            while (wordStart < i) {
                chs[k++] = chs[wordStart++];
            }
            if (k < chs.length) {
                chs[k++] = ' ';
            }else {
                return new String(chs);
            }
        }
        if (k == 0) {
            return "";
        }else {
            return new String(chs, 0, (k == chs.length && chs[k-1] != ' ') ? k : k-1);
        }
    }

    public void reverse(char chs[], int start, int end) {
        while (start < end) {
            chs[start] ^= chs[end];
            chs[end] ^= chs[start];
            chs[start] ^= chs[end];
            start++;
            end--;
        }
    }
}
