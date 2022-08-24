/**
 * @author BOOM
 * @create 2022-08-24 19:07
 */
package com.hhl.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hMap.containsKey(target-nums[i])){
                return new int[]{hMap.get(target-nums[i]), i};
            }
            hMap.put(nums[i], i);
        }
        return  null;
    }
}
