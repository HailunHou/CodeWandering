/**
 * @author BOOM
 * @create 2022-07-30 21:02
 */
package com.hhl.array;

import com.hhl.utils.ArrayUtils;

public class SortedSquares {
    public static void main(String[] args) {
        int[] array = {-9, -7, -5, -3, 1, 4, 6, 8, 19};
        ArrayUtils.foreachArray(new SortedSquares().sortedSquares_1(array));
    }

    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    public int[] sortedSquares_1(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int[] results = new int[nums.length];
        int i = nums.length-1;
        while(start <= end) {
            if(nums[start] * nums[start] < nums[end] * nums[end]) {
                results[i--] = nums[end] * nums[end];
                end--;
            }else {
                results[i--] = nums[start] * nums[start];
                start++;
            }
        }
        return results;
    }
}
