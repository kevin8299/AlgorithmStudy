package com.leetcode.maximum_subarray;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Solution_SumFirst {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // {-2, 1, -3, 4, -1, 2, 1, -5, 4} -- {4,−1,2,1} -- 6
        int len = nums.length;
        int[] sums = new int[len];
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            sums[i] = sum;
        }

        sum = Integer.MIN_VALUE;
        int d;
        for(int i = 0; i < len; i++)
            for(int j = 0; j < i; j++){
                d = sums[i] - sums[j];
                if(d > sum)
                    sum = d;
            }
        return sum;
    }
}
