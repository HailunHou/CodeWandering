/**
 * @author BOOM
 * @create 2022-08-09 18:54
 */
package com.hhl.utils;

public class ListUtils {
    /**
     * 给定元素数量n，随机生成链表
     * @param n
     * @return
     */
    public static ListNode creatList(int n) {
        ListNode head = new ListNode();
        head.val = 0;
        for (int i = 0; i < n; i++) {
            head.add((int) (Math.random() * 5));
        }
        return head;
    }
}
