package com.leetcode.majority_element;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Test {
    public static void main(String[] args){
        //int[] ds = {1,2,3,4,4,4,5,6,7,4};
        //int[] ds = {3,2,3};
        int[] ds = {6,6,6,7,7};
        Solution s = new Solution();
        System.out.println(s.majorityElement(ds));
    }
}
