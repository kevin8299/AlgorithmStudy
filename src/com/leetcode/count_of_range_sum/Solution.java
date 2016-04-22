package com.leetcode.count_of_range_sum;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        //  {-2, 5, -1}   lower = -2, upper = 2  ==>
        //   [0, 0]: -2, [2, 2]: -1, [0, 2]: 2  ==>  3
        if (nums == null || nums.length == 0) return 0;
        double[] sums = new double[nums.length];

        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sums[i] = nums[i] + sums[i - 1];

        int c = subSum(sums, lower, upper, 0);
        for(int i = 1; i < nums.length; i++)
            c += subSum(sums, (double)lower + sums[i - 1], (double)upper + sums[i - 1], i);

        return c;
    }

    int subSum(double[] sums, double lower, double upper, int start){
        int count = 0;
        for(int i = start; i < sums.length; i++)
            if(sums[i] >= lower && sums[i] <= upper)
                count++;
        return count;
    }

    public int countRangeSum1(int[] nums, int lower, int upper) {  // Why cannot this pass the testcase ???
        if(nums.length == 0) return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if(lower  <= sum[j] - sum[i] && sum[j] - sum[i] <= upper)
                    ans++;
            }
        }
        return ans;
    }

}
