package com.leetcode.find_the_duplicate_number;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1, mid = 0;
        while(low < high) {
            mid = low + (low + high) / 2;


        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {  // Wrong !!!  Has to interpret the question more deeply
        boolean same = true;
        for(int i = 1; i < nums.length; i++)
            if(nums[i] - nums[0] != 0){
                same = false;
                break;
            }
        if(same)
            return nums[0];

        int d = 0;
        for(int i = 1; i < nums.length; i++)
            d += nums[i] - i;
        return d + nums[0];
    }

    public int findDuplicate1(int[] nums) {
        //{1,2,3,4,5,6,7,8,9,9}  --  9
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
            if(nums[i] - nums[i - 1] == 0)
                return nums[i];
        return 0;
    }
}
