/**
 * @author BOOM
 * @create 2022-08-10 19:09
 */
package com.hhl.test;

import com.hhl.List.RemoveElements;
import com.hhl.array.Remove_Element;
import com.hhl.utils.ArrayUtils;
import com.hhl.utils.ListNode;
import com.hhl.utils.ListUtils;

import java.util.Scanner;

public class ArrayAndList {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 5, 6, 7, 7, 8, 9};
        Remove_Element re = new Remove_Element();
        long start = System.currentTimeMillis();
        System.out.println(re.removeElement(array, 5));
        long end = System.currentTimeMillis();
        System.out.println("数组删除需要时间：" + (end-start));
        ArrayUtils.foreachArray(array);

        ListNode list = ListUtils.creatList(9);
        list.foreachList();
        System.out.println("输入要删除的数字：");
        int val = new Scanner(System.in).nextInt();
        RemoveElements reL = new RemoveElements();
        start = System.currentTimeMillis();
        list = reL.removeElements_4(list, val);
        end = System.currentTimeMillis();
        System.out.println("链表删除需要时间：" + (end-start));
        list.foreachList();
    }
}
