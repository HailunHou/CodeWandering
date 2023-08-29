/**
 * @author BOOM
 * @create 2023-08-26 10:47
 */
package com.hhl.test.XD;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 @author boom
 @create 2023-08-26 10:47
 */
public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int j = 0; in.hasNextInt() && j < n; j++) {
                nums1[j] = in.nextInt();
            }
            for (int j = 0; in.hasNextInt() && j < n; j++) {
                nums2[j] = in.nextInt();
            }
            System.out.println(solution(n, m, nums1, nums2));
        }
        int n = 5;
        int m = 6;
        int[] nums1 = new int[]{-1,-2,3,4,5};
        int[] nums2 = new int[]{-1,3,4,2,5};
        System.out.println(solution(n, m, nums1, nums2));
    }
    public static String solution(int n, int m, int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = n-1;
        int temp = 0;
        while(left < right){
            temp = nums2[left];
            nums2[left] = nums2[right];
            nums2[right] = temp;
            left++;
            right--;
        }
        boolean res = true;
        for (int i = 0; i < n; i++) {
            if(!(nums1[i] + nums2[i] >= 1 && nums1[i] + nums2[i] <= m)){
                res = false;
                break;
            }
        }
        return res? "Yes" : "No";
    }
}
