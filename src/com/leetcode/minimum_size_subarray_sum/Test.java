package com.leetcode.minimum_size_subarray_sum;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Test {
    public static void main(String[] args){
        //int[] ds = {2,3,1,2,4,3};
        //int t = 7;

//        int[] ds = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
//        int t = 80;
        int[] ds = {1,2,3,4,5};
        int t = 15;
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(t, ds));
    }

}
