/**
 * @author BOOM
 * @create 2022-07-27 21:58
 */
package com.hhl.array;

public class Find_Num_Binary {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 9, 19, 50};
        Find_Num_Binary fn = new Find_Num_Binary();
        System.out.println(fn.findNum_1(array, 50));
        System.out.println(fn.findNum_2(array, 50));
        System.out.println(fn.findNumOrInsert(array, 51));
    }

    public int findNum_1(int[] array, int num){
        int start = 0;
        int end = array.length-1; //这里必须减一，如果不减一，在数组中没有需要查找的数，而这个数还是大于数组中所有数的，那么最后会搜索到array[array.length]，报指针溢出异常
        while (start <= end){
            int middle = start + ((end - start) >> 1);
            if(array[middle] < num) {
                start = middle + 1;
            }else if(array[middle] > num) {
                end = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public int findNum_2(int[] array, int num){
        int start = 0;
        int end = array.length; //这里必须减一，如果不减一，在数组中没有需要查找的数，而这个数还是大于数组中所有数的，那么最后会搜索到array[array.length]，报指针溢出异常
        while (start < end){
            int middle = start + (end - start)/2;
            if(array[middle] < num) {
                start = middle + 1;
            }else if(array[middle] > num) {
                end = middle;
            }else {
                return middle;
            }
        }
        return -1;
    }
    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
    */
    public int findNumOrInsert(int array[], int num){
        int start = 0;
        int end = array.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(array[mid] < num) {
                start = mid + 1;
            } else if (array[mid] > num) {
                end = mid - 1;
            } else {
                return mid;
            }

        }
        return start;
    }
}


