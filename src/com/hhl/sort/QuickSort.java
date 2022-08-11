/**
 * @author BOOM
 * @create 2022-08-11 17:05
 */
package com.hhl.sort;

import com.hhl.utils.ArrayUtils;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int nums[] = new int[]{3,5,1,0,-5,6,34,-7,24,2};
        qs.quickSort(nums, 0, nums.length-1);
        ArrayUtils.foreachArray(nums);
    }

    public void quickSort(int nums[], int start, int end) {
        if(start >= end) {
            return;
        }
        int partition = partition(nums, start, end);
        quickSort(nums, start, partition-1);
        quickSort(nums, partition+1, end);
    }

    public int partition(int nums[], int start, int end) {
        int pos = nums[start];
        int left = start;
        int right = end;
        while(left < right) {
            while(nums[right] > pos && left < right) {
                right--;
            }
            if(left < right) {
                nums[left++] = nums[right];
            }
            while(nums[left] < pos && left < right) {
                left++;
            }
            if(left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = pos;
        return left;
    }
}
