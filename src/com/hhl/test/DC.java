/**
 * @author BOOM
 * @create 2023-08-02 19:40
 */
package com.hhl.test;

/**
 @author boom
 @create 2023-08-02 19:40
 */
import java.util.*;

public class DC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入钾电池的种类数
        int k = scanner.nextInt(); // 输入需要购买的钾电池类数
        int[] voltage = new int[n]; // 存储每类钾电池的电压
        for (int i = 0; i < n; i++) {
            voltage[i] = scanner.nextInt(); // 输入每类钾电池的电压值
        }

        Arrays.sort(voltage); // 对电压值进行排序

        int left = 1, right = voltage[n - 1] - voltage[0]; // 初始化二分搜索的左右边界
        int maxDiff = -1; // 用于记录最大差异度

        while (left <= right) {
            int mid = left + (right - left) / 2; // 计算二分搜索的中间值

            if (isValid(voltage, k, mid)) {
                // 如果存在k类钾电池的组合，其电压差异度大于等于当前的二分搜索中间值
                maxDiff = mid; // 更新最大差异度
                left = mid + 1; // 继续向右搜索
            } else {
                right = mid - 1; // 否则向左搜索
            }
        }

        System.out.println(maxDiff); // 输出最大差异度
    }

    private static boolean isValid(int[] voltage, int k, int diff) {
        int count = 1; // 计数器，记录当前组合中的钾电池数量
        int minVoltage = voltage[0]; // 记录当前组合中的最小电压值

        for (int i = 1; i < voltage.length; i++) {
            if (voltage[i] - minVoltage >= diff) {
                // 如果当前钾电池与最小电压值之差大于等于当前差异度
                count++; // 增加钾电池数量
                minVoltage = voltage[i]; // 更新最小电压值
            }
        }

        return count >= k; // 返回是否存在k类钾电池的组合，其电压差异度大于等于当前的差异度
    }
}
