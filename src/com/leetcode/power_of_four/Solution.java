package com.leetcode.power_of_four;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Solution {

    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        int num0 = num, tmp = num;
        while(num0 > 0) {
            tmp = num0;
            num0 = num0 >> 2;
            if (tmp - 4 * num0 > 0) return false;
            if(num0 == 1) break;
        }
        return true;
    }

    public boolean isPowerOfFour1(int num) {
        if(num <= 0) return false;
        if((num & (num - 1)) > 0) return false;
        if((num & 0x55555555) > 0)
            return true;
        else
            return false;
    }
}
