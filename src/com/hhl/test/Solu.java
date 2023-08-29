/**
 * @author BOOM
 * @create 2023-08-01 20:40
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-01 20:40
 */
import java.util.*;

public class Solu {
    public static List<Integer> findNext(List<Integer> h) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = h.size() - 1; i >= 0; --i) {
            if (set.isEmpty() || set.higher(h.get(i)) == null) {
                set.add(h.get(i));
                result.add(-1);
            } else {
                set.add(h.get(i));
                result.add(set.higher(h.get(i)));
            }
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            h.add(tmp);
        }

        List<Integer> result = findNext(h);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
