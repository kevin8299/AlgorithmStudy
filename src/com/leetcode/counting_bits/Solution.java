package com.leetcode.counting_bits;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Solution {

    public int[] countBits(int num) {
        // 5 => [0,1,1,2,1,2].
        int[] res = new int[num + 1];
        if (num > 0){
            res[1] = 1;
            for (int i = 2; i <= num; i++)
                res[i] = res[i / 2] + res[i % 2];
        }
        return res;
    }

    public int[] countBits2(int num) {
        // 5 => [0,1,1,2,1,2].
        int[] o = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            int n = 0, d = i;
            while(d != 0){
                if(d % 2 != 0)
                    n++;
                d = d >> 1;
            }
            o[i] = n;
        }
        return o;
    }

}
