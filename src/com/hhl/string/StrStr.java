/**
 * @author BOOM
 * @create 2022-09-02 10:17
 */
package com.hhl.string;

public class StrStr {
    public static void main(String[] args) {
        String str = "aabaabaaf";
        String mat = "aabaaf";
        int[] next = new int[mat.length()];
        StrStr Str = new StrStr();
        Str.getNext(next, mat);
        System.out.println(Str.strStr(str, mat));
    }
    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i<s.length(); i++){
            while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }

            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i<haystack.length();i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }

    public void getNext_1(int[] next, String s) {
        //初始化
        int j = -1;
        next[0] = j;
        //处理前后缀不相同的情况
        for (int i = 1; i < s.length(); i++) {
            while(j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            //处理前后缀相同的情况
            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int strStr_1(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext_1(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            if (j == needle.length()-1) {
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}
