/**
 * @author BOOM
 * @create 2023-07-27 15:30
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-27 15:30
 */
import java.util.Scanner;
import java.io.PrintWriter;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(solve(n, x, arr));
        }
    }

    public static long solve(int n, int x, int[] arr) {
        long[][] dp = new long[n][2];
        dp[0][0] = Math.max(0, arr[0]);
        dp[0][1] = Math.max(0, x);
        long maxSum = Math.max(dp[0][0], dp[0][1]);

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + x, dp[i - 1][1] + x);
            maxSum = Math.max(maxSum, Math.max(dp[i][0], dp[i][1]));
        }

        return maxSum;
    }
}