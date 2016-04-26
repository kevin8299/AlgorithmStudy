package com.leetcode.reverse_string;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Solution {
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chs.length - 1; i >= 0; i--)
            sb.append(chs[i]);
        return sb.toString();
    }
}
