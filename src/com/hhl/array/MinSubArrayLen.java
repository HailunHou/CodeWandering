/**
 * @author BOOM
 * @create 2022-08-01 17:11
 */
package com.hhl.array;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen msa = new MinSubArrayLen();
        int[] array = new int[]{1,2,3,2,4,3};
        System.out.println(msa.minSubArrayLen(7, array));
        System.out.println(msa.minSubArrayLen_1(7, array));
        System.out.println(msa.minSubArrayLen_2(7, array));
    }

    /**
     * 方法：暴力循环
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int subLength = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                subLength = j - i + 1;
                if (sum >= s) {
                    result = result > subLength ? subLength : result;
                }
            }
        }
        return result;
    }

    /**
     * 自己写的
     * 方法：滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_1(int s, int[] nums) {
        int sum = 0;
        int subLength;
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                subLength = end - start + 1;
                result = result > subLength ? subLength : result;
                sum -= nums[start++];
            }
        }
        return result;
    }

    /**
     * 代码随想录上的标准答案
     * 核心：滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
