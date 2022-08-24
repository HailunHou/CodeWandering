/**
 * @author BOOM
 * @create 2022-08-23 10:37
 */
package com.hhl.hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(19));
    }
    public boolean isHappy(int n) {
        Set<Integer> hSet = new HashSet<Integer>();
        while(!hSet.contains(n)) {
            /*
            这两条语句的顺序不能颠倒
             */
            hSet.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
