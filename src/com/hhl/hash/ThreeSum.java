/**
 * @author BOOM
 * @create 2022-08-27 16:56
 */
package com.hhl.hash;

import java.util.*;

public class ThreeSum {
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重left
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    //去重right
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return list;
    }

    /**
     * 哈希法(还没看懂)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            Set<Integer> hSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 2 && nums[j] == nums[j-1] && nums[j-1] == nums[j-2]) {
                    continue;
                }
                int c = 0 - (nums[i] + nums[j]);
                if (hSet.contains(c)) {
                    list.add(Arrays.asList(nums[i], nums[j], c));
                    hSet.remove(c);
                }else {
                    hSet.add(nums[j]);
                }
            }
        }
        return list;
    }
}
