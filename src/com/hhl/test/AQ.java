/**
 * @author BOOM
 * @create 2023-07-24 10:00
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-24 10:00
 */
import java.util.*;
import java.io.*;

public class AQ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nx = br.readLine().split(" ");
            int n = Integer.parseInt(nx[0]);
            int x = Integer.parseInt(nx[1]);

            String[] arrStr = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            long[] dp = new long[n];
            dp[0] = arr[0];
            long maxSum = dp[0];

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
                maxSum = Math.max(maxSum, dp[i]);
            }

            dp[0] = x;
            long maxSumWithX = Math.max(maxSum, dp[0]);

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(x, dp[i - 1] + x);
                maxSumWithX = Math.max(maxSumWithX, dp[i]);
            }

            System.out.println(Math.max(maxSum, maxSumWithX));
        }
    }
}