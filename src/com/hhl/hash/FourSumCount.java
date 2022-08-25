/**
 * @author BOOM
 * @create 2022-08-25 15:06
 */
package com.hhl.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        for (int i : nums1){
            for (int j : nums2){
                int temp = i + j;
                if(hMap.containsKey(temp)) {
                    hMap.put(temp, hMap.get(temp) + 1);
                }else {
                    hMap.put(temp, 1);
                }
            }
        }

        int res = 0;
        for (int i : nums3){
            for (int j : nums4){
                int temp = i + j;
                if(hMap.containsKey(0 - temp)){
                    res += hMap.get(0 - temp);
                }
            }
        }
        return res;
    }
}
