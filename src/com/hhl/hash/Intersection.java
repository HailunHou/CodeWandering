/**
 * @author BOOM
 * @create 2022-08-20 11:14
 */
package com.hhl.hash;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hSet = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            hSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        return resultSet.stream().mapToInt(x -> x).toArray();
    }
}
