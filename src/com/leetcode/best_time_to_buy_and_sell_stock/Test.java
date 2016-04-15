package com.leetcode.best_time_to_buy_and_sell_stock;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Test {

    public static void main(String[] args){
        int[] stocks = {3, 4, 7, 9, 1, 8, 4};
        Solution s = new Solution();
        int profit = s.maxProfit(stocks);
        System.out.println("Max Profit is " + profit);

    }

}
