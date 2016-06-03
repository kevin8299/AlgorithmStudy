package com.leetcode.find_peak_element;

/**
 * Created by Administrator on 2016/4/29.
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        //{1, 2, 3, 1}  ---  2
        int start = 0, end = nums.length - 1;
        int out = 0;
        while(start <= end){
            if(start == end){
                out = start;
                break;
            }
            int mid = (start + end) / 2;
            if(nums[start] < nums[mid])
                if(nums[mid] < nums[mid + 1])
                    start = mid + 1;
                else
                    start = mid;
            else
                if(mid == start)
                    start = mid + 1;
                else
                    end = mid;
        }

        return out;
    }


    public int findPeakElement2(int[] nums) {
        //{1, 2, 3, 1}  ---  2
        for(int i = 1; i < nums.length; i++)
            if(nums[i] - nums[i - 1] < 0)
                return i - 1;

        return nums.length - 1;
    }

    public int findPeakElement1(int[] nums) {
        //{1, 2, 3, 1}  ---  2
        if(nums.length == 1) return 0;
        int peak = Integer.MIN_VALUE, idx = -1;
        for(int i = 0; i < nums.length; i++){
            int prev = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
            int mid = nums[i];
            int next = i == nums.length - 1? Integer.MIN_VALUE : nums[i + 1];

            if(mid > prev  && next < mid) {
                if(mid > peak){
                    peak = mid;
                    idx = i;
                }
            }
        }
        return idx;
    }
}
