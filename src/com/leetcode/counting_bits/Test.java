package com.leetcode.counting_bits;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Test {

    public static void main(String[] args){
        // 5 => [0,1,1,2,1,2].
        int n = 5;
        Solution s = new Solution();
        for(int i: s.countBits(n))
            System.out.print(i + " ");
    }
}
