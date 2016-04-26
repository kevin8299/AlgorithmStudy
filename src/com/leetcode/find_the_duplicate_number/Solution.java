package com.leetcode.find_the_duplicate_number;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        //{1,2,3,4,5,6,7,8,9,9}  --  9
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
            if(nums[i] - nums[i - 1] == 0)
                return nums[i];
        return 0;
    }
}
