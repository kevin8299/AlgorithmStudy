package com.leetcode.remove_duplicate_from_sorted_array;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[idx] != 0){
                ++idx;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
