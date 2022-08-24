/**
 * @author BOOM
 * @create 2022-08-11 21:08
 */
package com.hhl.List;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        MyLinkList mll = new MyLinkList();
        mll.addAtTail(1);
        mll.addAtTail(2);
        mll.addAtTail(3);
        mll.addAtTail(4);
        mll.addAtTail(5);
        RemoveNthFromEnd rnf = new RemoveNthFromEnd();
        mll.head.next = rnf.removeNthFromEnd(mll.head.next, 5);
        for (int i = 0; i < 4; i++) {
            System.out.println(mll.get(i));
        }
    }

    /**
     * 写错了，这是删除正数第n个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        int count = 1;
        ListNode prev = new ListNode();
        prev.next = head;
        if(n == 1) {
            prev.next = prev.next.next;
            return prev.next;
        }
        while(count++ < n && prev.next != null) {
            prev = prev.next;
        }
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }

    /**
     * 代码随想录标准答案
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        prev.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return dummy.next;
    }
}
