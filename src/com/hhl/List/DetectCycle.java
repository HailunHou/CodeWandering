/**
 * @author BOOM
 * @create 2022-08-12 21:17
 */
package com.hhl.List;

/**
 * 环形链表
 */
public class DetectCycle {
    /**
     * 代码随想录标准答案
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    /**
     * 自己写的
     * @param head
     * @return
     */
    public ListNode detectCycle_1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode index1 = null;
        ListNode index2 = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //有环
                index1 = head;
                index2 = fast;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
            }
        }
        return index1;
    }
}
