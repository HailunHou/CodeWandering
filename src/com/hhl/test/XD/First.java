/**
 * @author BOOM
 * @create 2023-08-26 10:20
 */
package com.hhl.test.XD;



import java.util.*;
public class First {
    public static void main(String[] args) {
        long MOD = (long)Math.pow(10, 9) + 7;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        long sum = 0;

        while(k > 0){
            Arrays.sort(nums);
            int oneIndex = -1;
            for (int i = 0; i < n; i++) {
                if(nums[i] == 1){
                    oneIndex = i+1;
                }else{
                    break;
                }
            }
            if(oneIndex == -1 || oneIndex == n){
                oneIndex = 0;
            }
            long ai = nums[(oneIndex+n-1)/2];
            long aj = nums[(oneIndex+n-1)/2+1];
            long x = 1;
            long y = ai * aj;
            nums[(oneIndex+n-1)/2] = x;
            nums[(oneIndex+n-1)/2+1] = y;
            k--;
        }
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        System.out.println(sum%MOD);
    }
}
