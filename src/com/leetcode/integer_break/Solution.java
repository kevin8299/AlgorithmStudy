package com.leetcode.integer_break;

/**
 * Created by Administrator on 2016/6/3.
 */
public class Solution {

    public int integerBreak(int n) {
        // n = 2 ==> 1 (2 = 1 + 1)
        // n = 10 ==> 36 (10 = 3 + 3 + 4)
        int o = 1;
        if(n == 2 || n == 3) return n - 1;
        while(n > 4){
            o *= 3;
            n -= 3;
        }
        o *= n;
        return o;
    }

}
