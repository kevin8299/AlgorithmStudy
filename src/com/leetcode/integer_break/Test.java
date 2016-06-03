package com.leetcode.integer_break;

/**
 * Created by Administrator on 2016/6/3.
 */
public class Test {

    public static void main(String[] args){
        // n = 2 ==> 1 (2 = 1 + 1)
        // n = 10 ==> 36 (10 = 3 + 3 + 4)
        int n = 10;
        Solution s = new Solution();
        System.out.println(s.integerBreak(n));
    }

}
