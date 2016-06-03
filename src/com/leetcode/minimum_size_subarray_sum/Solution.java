package com.leetcode.minimum_size_subarray_sum;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = nums.length - 1;
        return sublen(nums, s, start, end);
    }

    int sublen(int[] nums, int s, int start, int end){
        if(start == end)
            if(nums[start] >= s)
                return 1;
            else
                return 0;

        int mid = (start + end) / 2;
        int smaller1 = sublen(nums, s, start, mid);
        int smaller2 = sublen(nums, s, mid + 1, end);
        int small = smaller1 < smaller2 ? smaller1 : smaller2;

        int sum = nums[mid];
        if(sum >= s) return 1;
        else{
            int idx0 = mid, idx1 = mid;
            while(true) {
                if(sum >= s)
                    return idx1 - idx0 + 1;
                if(idx0 == start && idx1 == end)
                    return Integer.MAX_VALUE;

                int x0 = idx0 - 1;
                if(x0 >= start){
                    sum += nums[x0];
                    if(sum >= s)
                        return idx1 - x0 + 1;
                }



            }
        }


    }



    public int minSubArrayLen3(int s, int[] nums) {
        //{2,3,1,2,4,3} 7 --- {4,3}
        if(nums == null || nums.length == 0) return 0;
        int start = -1, end = -1, minLen = nums.length + 1, sum = 0;

        while(start < nums.length && end < nums.length){
            while(sum < s){
                ++start;
                if(start == nums.length)
                    break;
                sum += nums[start];
            }

            while(sum >= s){
                ++end;
                int len = start - end + 1;
                if(minLen > len) minLen = len;
                sum -= nums[end];
            }
        }

        return minLen <= nums.length ? minLen : 0;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        //{2,3,1,2,4,3} 7 --- {4,3}
        if(nums == null || nums.length == 0) return 0;

        int[] subSum = new int[nums.length];
        subSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            subSum[i] = subSum[i - 1] + nums[i];

        if(subSum[nums.length - 1] < s) return 0;

        int minLen = nums.length;
        for(int i = 0; i < subSum.length; i++){
            if(subSum[i] >= s && i < minLen)
                    minLen = i;

            for(int j = 0; j < i; j++) {
                int sum = subSum[i] - subSum[j];
                if(sum >= s){
                    int len = i - j;
                    if(len < minLen)
                        minLen = len;
                }
            }
        }
        return minLen;
    }

    public int minSubArrayLen1(int s, int[] nums) {   // Wrong understanding of the question !!!
        //{2,3,1,2,4,3} 7 --- {4,3}
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 0, out = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if(sum >= s){
                out = nums.length - i;
                break;
            }
        }
        return out;
    }
}











