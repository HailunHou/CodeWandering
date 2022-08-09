/**
 * @author BOOM
 * @create 2022-07-30 18:54
 */
package com.hhl.array;
import com.hhl.utils.ArrayUtils;

public class Remove_Element {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 5, 6, 7, 7, 8, 9, 8};
        Remove_Element re = new Remove_Element();
        System.out.println(re.removeElement(array, 5));
        ArrayUtils.foreachArray(array);
        int[] array_1 = {1, 3, 4, 5, 5, 6, 7, 7, 8, 9, 8};
        System.out.println(re.removeElement_1(array_1, 8));
        ArrayUtils.foreachArray(array_1);
    }
    public int removeElement(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
    public int removeElement_1(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
