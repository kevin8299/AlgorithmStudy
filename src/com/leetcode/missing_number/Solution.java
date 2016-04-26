package com.leetcode.missing_number;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        //{0, 1, 3}  ---  2
        int max = nums[0], min = nums[0];
        int sum0 = 0, sum1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i])
                max = nums[i];
            if(min > nums[i])
                min = nums[i];
            sum0 += nums[i];
        }

        for(int i = 1; i <= max; i++)
            sum1 += i;

        int out = sum1 - sum0;
        if(out == 0){
            if(min == 0)
                out = max + 1;
            else
                out = 0;
        }

        return out;
    }
}
