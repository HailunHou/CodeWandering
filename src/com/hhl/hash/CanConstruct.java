/**
 * @author BOOM
 * @create 2022-08-26 16:10
 */
package com.hhl.hash;

import java.util.HashSet;
import java.util.Set;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dic = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            dic[ransomNote.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < magazine.length(); i++) {
            dic[magazine.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
