/**
 * @author BOOM
 * @create 2023-09-01 10:46
 */
package com.hhl.greed;

/**
 @author boom
 @create 2023-09-01 10:46
 */
// 122. 买卖股票的最佳时机 II
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices){
        int maxPf = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0){
                maxPf += prices[i]-prices[i-1];
            }
        }
        return maxPf;
    }
}
