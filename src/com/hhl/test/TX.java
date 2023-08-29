/**
 * @author BOOM
 * @create 2023-08-13 15:52
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-13 15:52
 */
import java.util.Scanner;

public class TX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            t = scanner.nextInt();
            s1.append(t);
        }

        for (int i = 0; i < n; i++) {
            t = scanner.nextInt();
            s2.append(t);
        }

        String str1 = s1.toString();
        String str2 = s2.toString();

        if (str1.equals(str2)) {
            long result = (long) n * (n + 1) / 2;
            System.out.println(result);
            return;
        }

        int cnt = 0;
        for (int l = 2; l <= n - 1; l++) {
            for (int i = 0; i <= str1.length() - l; i++) {
                String tmp = str1.substring(i, i + l);
                if (str2.indexOf(tmp) != -1) {
                    cnt++;
                }
            }
        }

        long result = (long) n * (n + 1) - n - cnt;
        System.out.println(result);
    }
}