/**
 * @author BOOM
 * @create 2022-08-03 19:34
 */
package com.hhl.array;

import com.hhl.utils.ArrayUtils;

public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix gm = new GenerateMatrix();
        ArrayUtils.foreachArray(gm.generateMatrix(6));
        ArrayUtils.foreachArray(gm.generateMatrix_1(6));
        ArrayUtils.foreachArray(gm.generateMatrix_re(6));
    }

    /**
     * 自己写的，参考标准答案
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix_1(int n) {
        int[][] nums = new int[n][n];
        int start = 0;
        int i, j;
        int loop = 0;
        int count = 1;
        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                nums[start][j] = count;
                count++;
            }

            for (i = start; i < n - loop; i++) {
                nums[i][j] = count;
                count++;
            }

            for (; j > 0; j--) {
                nums[i][j] = count;
                count++;
            }

            for (; i > 0; i--) {
                nums[i][j] = count;
                count++;
            }
            start++;
//            if(n % 2 == 1) {
//                nums[n/2+1][n/2+1] = n*n;
//            }
        }
        if (n % 2 == 1) {
            nums[start][start] = count;
        }
        return nums;
    }

    /**
     * 代码随想录标准答案
     * 方法：考察代码掌握力，循环不变量原则
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }

    public int[][] generateMatrix_re(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= start+1; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= start+1; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
