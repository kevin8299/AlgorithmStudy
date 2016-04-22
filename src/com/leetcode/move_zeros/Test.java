package com.leetcode.move_zeros;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Test {
    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};  // 1, 3, 12, 0, 0
        Solution s = new Solution();
        s.moveZeroes(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
