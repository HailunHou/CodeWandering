/**
 * @author BOOM
 * @create 2023-03-18 10:44
 */
package com.hhl.meituan;

/**
 @author boom
 @create 2023-03-18 10:44
 */
import java.util.*;

public class RibbonCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ribbon = new int[n];
        for (int i = 0; i < n; i++) {
            ribbon[i] = scanner.nextInt();
        }
        int ans = cutRibbon(ribbon, k);
        System.out.println(ans);
    }

    private static int cutRibbon(int[] ribbon, int k) {
        int ans = 0;
        Map<Integer, Integer> colorCounts = new HashMap<>();
        int i = 0;
        for (int j = 0; j < ribbon.length; j++) {
            colorCounts.put(ribbon[j], colorCounts.getOrDefault(ribbon[j], 0) + 1);
            while (colorCounts.size() > k) {
                colorCounts.put(ribbon[i], colorCounts.get(ribbon[i]) - 1);
                if (colorCounts.get(ribbon[i]) == 0) {
                    colorCounts.remove(ribbon[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
