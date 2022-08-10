/**
 * @author BOOM
 * @create 2022-08-09 19:28
 */
package com.hhl.List;

import com.hhl.utils.ListNode;
import com.hhl.utils.ListUtils;

import java.util.Scanner;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode list = ListUtils.creatList(20);
        list.foreachList();
        System.out.println("输入要删除的数字：");
        int val = new Scanner(System.in).nextInt();
        RemoveElements re = new RemoveElements();
        list = re.removeElements_4(list, val);
        list.foreachList();
    }
    /*
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }
        if (){

        }
        ListNode p = head;
        ListNode q = p.next;
        do{
            if (){

            }
        }while (q != null);
        return null;
    }
    */

    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_3(ListNode head, int val) {
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 自己实现
     * 不添加虚拟头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_4(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
//        System.out.println("head:"+head);
//        System.out.println("pre:"+pre);
        while (head.val == val) {
            head = head.next;
        }
//        System.out.println("head:"+head);
//        System.out.println("pre:"+pre);

        while (cur != null){
            if(cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
