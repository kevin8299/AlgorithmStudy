package com.leetcode.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> solo = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            if(!solo.add(nums[i]))
                return true;
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {  // has limit of bit size of int or long
        if(nums == null || nums.length == 0 || nums.length == 1) return false;

        int record = 1 << nums[0];
        for(int i = 1; i < nums.length; i++){
            int t = 1 << nums[i];
            if((record & t) != 0) return true;
            record |= t;
        }

        return false;
    }
}
