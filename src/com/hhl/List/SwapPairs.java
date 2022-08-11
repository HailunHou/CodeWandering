/**
 * @author BOOM
 * @create 2022-08-11 19:56
 */
package com.hhl.List;

public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs sp = new SwapPairs();
        MyLinkList mll = new MyLinkList();
        mll.addAtTail(1);
        mll.addAtTail(2);
        mll.addAtTail(3);
        mll.addAtTail(4);
        mll.addAtTail(5);
//        mll.addAtTail(6);
        System.out.println("run");
        mll.head.next = sp.swapPairs_1(mll.head.next);
        for (int i = 0; i < 5; i++) {
            System.out.println(mll.get(i));
        }
    }
    /**
     * 代码随想录标准答案
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位
        }
        return dummyNode.next;
    }

    public ListNode swapPairs_1(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        ListNode p2 = null;
        ListNode p3 = null;
        while(p1.next != null && p1.next.next != null) {
            p2 = p1.next;
            p3 = p1.next.next.next;
            p1.next = p1.next.next;
            p1.next.next = p2;
            p2.next = p3;
            p1 = p2;
        }
        return dummyHead.next;
    }
}
