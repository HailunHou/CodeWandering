/**
 * @author BOOM
 * @create 2022-08-09 18:50
 */
package com.hhl.utils;

public class ListNode {
    // 结点的值
    public int val;

    // 下一个结点
    public ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if (this.next == null)
            this.next = newNode;
        else
            this.next.add(newval);
    }
    public void foreachList() {
        ListNode p = this;
        System.out.print(p.val+" ");
        while (p.next != null){
            p = p.next;
            System.out.print(p.val+" ");
        }
        System.out.println();
    }
}