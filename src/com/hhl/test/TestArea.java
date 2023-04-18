/**
 * @author BOOM
 * @create 2023-04-04 21:49
 */
package com.hhl.test;

import com.hhl.hash.Intersection;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.net.Inet4Address;
import java.time.Year;
import java.util.*;
import java.util.stream.IntStream;

/**
 @author boom
 @create 2023-04-04 21:49
 */



public class TestArea {

    class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            backTracking(n, k, 1);
            lists.forEach(System.out::println);
            return lists;
        }

        public void backTracking(int n, int k, int startIndex){
            if(list.size() == k){
                lists.add(new ArrayList<>(list));
                lists.forEach(System.out::println);
                return;
            }

            for(int i=startIndex; i <= n; i++){
                list.add(i);
                backTracking(n, k, i+1);
                list.remove(list.size()-1);
            }

        }
    }

//    class Solution {
//        List<List<Integer>> result = new ArrayList<>();
//        LinkedList<Integer> path = new LinkedList<>();
//        public List<List<Integer>> combine(int n, int k) {
//            combineHelper(n, k, 1);
//            result.forEach(System.out::println);
//            return result;
//        }
//
//        /**
//         * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
//         * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
//         */
//        private void combineHelper(int n, int k, int startIndex){
//            //终止条件
//            if (path.size() == k){
//                result.add(new ArrayList<>(path));
//                return;
//            }
//            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
//                path.add(i);
//                combineHelper(n, k, i + 1);
//                path.removeLast();
//            }
//        }
//    }

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
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.isEmpty();
//        deque.peekFirst();
//        deque.addLast(1);
//        deque.pollLast();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        lists.add(list1);
        lists.add(list2);
        lists.forEach(System.out::println);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.remove(arrayList.size()-1);
//        arrayList.forEach(System.out::println);

    }

    @Test
    public void test9(){
        Solution solution = new Solution();
        solution.combine(4, 2);
    }

}
