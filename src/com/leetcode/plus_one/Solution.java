package com.leetcode.plus_one;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Solution {
    int ad = -1;
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;

        plus(digits, digits.length - 1);
        if(ad == 1){
            int[] result = new int[digits.length + 1];
            for(int i = digits.length - 1; i > 0; i--)
                result[i] = digits[i];
            result[0] = 1;
            return result;
        }
        else
            return digits;
    }

    void plus(int[] d, int idx){
        if(idx == -1 || ad == 0)
            return;
        ad = 0;
        if(d[idx] < 9){
            d[idx] += 1;
        }
        else {
            d[idx] = 0;
            ad = 1;
            plus(d, --idx);
        }
    }

}
