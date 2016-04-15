package com.leetcode.best_time_to_buy_and_sell_stock;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // { 3, 4, 7, 9, 1, 8, 4 }
        int low = prices[0], max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < low) low = prices[i];
            else if(prices[i] - low > max) max = prices[i] - low;
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        // { 3, 4, 7, 9, 1, 8, 4 }
        int a = prices[0], b = prices[0], profit = 0, result = 0;
        for(int i = 1; i < prices.length; i++){
            System.out.println(a + " " + b + " " + profit);
            if(prices[i] > b) {
                b = prices[i];
                profit = b - a;
                if(result < profit)
                    result = profit;
            }
            else if(prices[i] < a){
                a = b = prices[i];
                profit = 0;
            }
        }
        return result;
    }
}
