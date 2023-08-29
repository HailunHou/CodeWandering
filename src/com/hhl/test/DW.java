/**
 * @author BOOM
 * @create 2023-08-23 20:57
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-23 20:57
 */
import java.util.Scanner;
import java.util.Arrays;

public class DW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums); // 将数字数组排序

        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= nums[i]; j--) {
                if (dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }

        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println("No solution");
        } else {
            System.out.println(dp[m]);
        }
    }
}
