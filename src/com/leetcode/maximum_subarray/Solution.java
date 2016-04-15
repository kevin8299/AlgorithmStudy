package com.leetcode.maximum_subarray;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0, sumMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > sumMax) sumMax = sum;
            if(sum < 0) sum = 0;
        }
        return sumMax;
    }

    public int maxSubArray1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxEndingHere = nums[0], maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxEndingHere < 0) maxEndingHere = nums[i];
            else maxEndingHere += nums[i];
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }



    public int maxSubArray2(int[] nums) {  // {8, -19, 5, -4, 20}  cannot pass this case
        // {-2, 1, -3, 4, -1, 2, 1, -5, 4} -- {4,−1,2,1} -- 6
        int start = 0, end = 0, max = nums[0], maxNow = nums[0];
        for(int i = 1; i < nums.length; i++){
            for(int j = end + 1; j <= i; j++)
                maxNow += nums[j];
            if(maxNow > max){
                max = maxNow;
                end = i;
            }

            if(max < nums[i]){
                start = i;
                end = i;
                max = nums[i];
                maxNow = max;
            }
        }
        return max;
    }
}
