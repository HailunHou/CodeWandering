/**
 * @author BOOM
 * @create 2022-08-30 15:47
 */
package com.hhl.string;

public class ReplaceSpace {
    /**
     * 自己写的
     * 双指针法
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char chs[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                count++;
            }
        }
        char strs[] = new char[chs.length+(count*2)];
        for (int i = 0; i < chs.length; i++) {
            strs[i] = chs[i];
        }
        int left = chs.length-1;
        int right = strs.length-1;
        while(left >= 0){
            if (strs[left] == ' ') {
                strs[right--] = '0';
                strs[right--] = '2';
                strs[right--] = '%';
                left--;
            }else {
                strs[right--] = strs[left--];
            }
        }
        return new String(strs);
    }
}
