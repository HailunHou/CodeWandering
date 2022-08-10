/**
 * @author BOOM
 * @create 2022-08-10 19:31
 */
package com.hhl.List;

class ListNode {
    ListNode next;
    int val;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 所有带_1后缀的方法都是自己实现
 * 不带_1的为代码随想录标准答案
 */
public class MyLinkList {
    int size;
    ListNode head;

    public MyLinkList() {
        size = 0;
        head = new ListNode(0);
    }

    //获取第index个节点的数值
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }


    public int get_1(int index) {
        if(index < 0 || index > size-1) {
            return -1;
        }
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
        ListNode cur = head.next;
        int count = 0;
        while (count < size){
            if(count == index) {
                break;
            }
            count++;
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead_1(int val) {
        size++;
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
//        addAtIndex(0, val);
    }

    public void addAtTail_1(int val) {
        size++;
        ListNode cur = head.next;
        while (cur.next != null){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        cur.next = newNode;
//        addAtIndex(size, val);
    }

    public void addAtIndex_1(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pred.next;
        pred.next = newNode;
    }

    public void deleteAtIndex_1(int index) {
        if(index < 0 || index > size-1) {
            return;
        }
        size--;
        ListNode pred = head;
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
            cur = pred.next;
        }
        pred.next = cur.next;
    }


    public static void main(String[] args) {
        MyLinkList linkedList = new MyLinkList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);//链表变为1->2->3
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println(linkedList.get(1));//返回2
        linkedList.deleteAtIndex(1);//现在链表是1->3
        System.out.println(linkedList.get(1));//返回3
    }

}
