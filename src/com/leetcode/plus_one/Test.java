package com.leetcode.plus_one;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Test {
    public static void main(String[] args){
        int[] d = {9,9};
        Solution s = new Solution();
        int[] out = s.plusOne(d);
        for(int i = 0; i < out.length; i++)
            System.out.print(out[i] + " ");
    }
}
