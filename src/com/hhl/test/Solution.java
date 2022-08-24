/**
 * @author BOOM
 * @create 2022-08-13 16:24
 */
package com.hhl.test;

import java.util.LinkedList;

class T {
    public static void main(String[] args) {
//        test(1);
//        test(2);
//        test(3);
        test(4);
    }

    private static void test(int n) {
        LinkedList list = new LinkedList();
        if (n < 2) {
            list.add(n);
            System.out.println(list.toString());
            return;
        }
        list.add(n);
        for (int i = n - 1; i > 0; i--) {
            swapFirstAndLast(list, i);
        }
        System.out.println(list.toString());
    }

    private static void swapFirstAndLast(LinkedList<Integer> list, int next) {
        int first = list.removeFirst();
        list.addLast(first);
        list.addLast(next);
    }
}