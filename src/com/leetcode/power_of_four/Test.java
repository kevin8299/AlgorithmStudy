package com.leetcode.power_of_four;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Test {
    public static void main(String[] args){
        int[] ds = {16, 5, 1, 4, 0};
        Solution s = new Solution();
        for(int i = 0; i < ds.length; i++)
            System.out.println(s.isPowerOfFour(ds[i]));
    }
}
