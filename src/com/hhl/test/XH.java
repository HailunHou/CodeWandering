/**
 * @author BOOM
 * @create 2023-07-31 10:14
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-07-31 10:14
 */
import java.util.*;

public class XH {
    public static void main(String[] args) {
        int n = 4;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2,3,4});
        list.add(new int[]{4,1,2,3});
        int solution = solution(n, list);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, List<int[]> list) {
        int[] first = list.get(0);
        int count = n * (n + 1) / 2 * list.size() - n;
        for (int len = 2; len <= first.length; len++) {
            int left = 0;
            int right = len - 1;
            for (int i = 1; i < list.size(); i++) {
                int[] temp = list.get(i);
                int tleft = left;
                int tright = right;
                while (tright < temp.length) {
                    int templeft = tleft;
                    for (int fidx = 0; fidx < first.length; fidx++) {
                        while (fidx < first.length && temp[templeft] == first[fidx]) {
                            templeft++;
                            fidx++;
                        }

                        if (templeft > tright) {
                            count--;
                            break;
                        }
                    }
                    tleft++;
                    tright++;
                }
            }
        }

        return count;
    }
}
