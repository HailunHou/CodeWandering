/**
 * @author BOOM
 * @create 2023-04-04 21:49
 */
package com.hhl.test;

import org.junit.Test;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;

/**
 @author boom
 @create 2023-04-04 21:49
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}


public class TestArea {

    @Test
    public void test1(){
        System.out.println("(int)'a' = " + (int) 'a');
    }

    @Test
    public void test2(){
        HashMap<Integer,Integer> numMap = new HashMap<>();
        numMap.put(5, 1);
        System.out.println(numMap);
        numMap.put(5, 1);
        System.out.println(numMap);
    }

    @Test
    public void test3(){
        HashMap<Integer,Integer> numMap = new HashMap<>();
        numMap.put(5, 1);
        System.out.println(numMap);
        Integer integer = numMap.get(5);
        System.out.println(integer.intValue());
    }

    @Test
    public void test4(){
        Set<Integer> numsSet = new HashSet<>();
        numsSet.add(10);
        System.out.println("numsSet.contains(10) = " + numsSet.contains(10));

    }

    @Test
    public void test5(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println("twoSum(nums, target) = " + twoSum(nums, target));
    }

    public int[] twoSum(int nums[], int target){
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numsMap.containsKey(target-nums[i])){
                return new int[]{i, numsMap.get(target-nums[i]).intValue()};
            }
            numsMap.put(nums[i], i);
        }
        return nums;
    }

    @Test
    public void test6(){
        int nums[] = new int[]{1,4,33,6,2};
        IntStream sorted = Arrays.stream(nums).sorted();
        int[] ints = sorted.toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void test7(){
        String s = "  hello world  ";
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, 'a');
        s = sb.toString();
        System.out.println(s);
    }

    @Test
    public void test8(){
        Solution solution = new Solution();
        String ss = "aabaaaaaf";
        String pp = "aaaaaf";
        solution.strStr(ss, pp);
    }



}
