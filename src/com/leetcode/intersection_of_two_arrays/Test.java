package com.leetcode.intersection_of_two_arrays;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Test {
    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2}; //[2].
        Solution s = new Solution();
        for(int i: s.intersection(nums1, nums2))
            System.out.println(i + "  ");

    }
}
