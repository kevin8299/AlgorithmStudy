package com.leetcode.string_to_integer;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Solution {
    public int myAtoi(String str) {
        int sign = 1, begin = 0;
        long out = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(begin == 0) {
                if(ch == ' ') continue;
                if (ch >= '0' && ch <= '9') {
                    out = ch - '0';
                    begin = 1;
                }
                else if(ch == '+'){
                    sign = 1;
                    begin = 1;
                }
                else if (ch == '-') {
                    sign = -1;
                    begin = 1;
                }
                else
                    return 0;
            }
            else {
                if(ch >= '0' && ch <= '9'){
                    out = 10 * out + ch - '0';
                    if(out > Integer.MAX_VALUE)
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else break;
            }
        }
        return sign * (int)out;
    }
}
