/**
 * @author BOOM
 * @create 2023-08-24 19:46
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-24 19:46
 */
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 2*n; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        GrayCode grayCodeGenerator = new GrayCode();
        List<Integer> grayCodeSequence = grayCodeGenerator.grayCode(n);
        System.out.println(grayCodeSequence);
    }
}
