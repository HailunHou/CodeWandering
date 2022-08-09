/**
 * @author BOOM
 * @create 2022-07-30 20:49
 */
package com.hhl.utils;

public class ArrayUtils {
    public static void foreachArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void foreachArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
