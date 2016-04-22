package com.leetcode.move_zeros;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // {0, 1, 0, 3, 12};   1, 3, 12, 0, 0
        if(nums == null || nums.length == 0) return;
        int idx = -1;

        for(int i = 0; i < nums.length; i++){
            if(idx == -1) {
                if (nums[i] == 0)
                    idx = i;
            }
            else{
                if(nums[i] != 0){
                    swap(nums, idx, i);
                    idx++;
                }
            }

        }
    }

    public void swap(int[] a, int p, int q){
        int d = a[p];
        a[p] = a[q];
        a[q] = d;
    }

}
