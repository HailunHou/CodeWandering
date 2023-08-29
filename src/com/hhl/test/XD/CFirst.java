/**
 * @author BOOM
 * @create 2023-08-26 10:30
 */
package com.hhl.test.XD;

/**
 @author boom
 @create 2023-08-26 10:30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CFirst {
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] elements = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(elements[i]);
        }

        long result = maximizeArraySum(n, k, arr);
        System.out.println(result);
    }

    static long maximizeArraySum(int n, int k, long[] arr) {
        Arrays.sort(arr);

        long ans = 1;
        for (int i = n - k; i < n; i++) {
            ans = (ans * arr[i]) % MOD;
        }
        return ans;
    }
}
