/**
 * @author BOOM
 * @create 2022-08-10 21:21
 */
package com.hhl.List;

public class ReverseList {
    public static void main(String[] args) {
        MyLinkList mll = new MyLinkList();
        mll.addAtHead(1);
        mll.addAtHead(2);
        mll.addAtHead(3);
        for (int i = 0; i < mll.size; i++) {
            System.out.println(mll.get(i));
        }
        ReverseList rl = new ReverseList();
        mll.head.next = rl.reverseList_2(mll.head.next);
        for (int i = 0; i < mll.size; i++) {
            System.out.println(mll.get(i));
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 递归形式
     */
    public ListNode reverseList_1(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pred, ListNode cur) {
        if (cur == null) {
            return pred;
        }
        ListNode temp = cur.next;
        cur.next = pred;
        return reverse(cur, temp);
    }

    /**
     * 从后向前递归
     * @param head
     * @return
     */
    ListNode reverseList_2(ListNode head) {
        // 边缘条件判断
        if (head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList_2(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
}
