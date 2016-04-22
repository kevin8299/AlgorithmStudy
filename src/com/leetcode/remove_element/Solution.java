package com.leetcode.remove_element;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        //{3,2,2,3}  --  2: {2,2, ...}
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
