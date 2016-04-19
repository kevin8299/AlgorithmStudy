package com.leetcode.Zigzag_Conversion;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Solution {
    public String convert(String s, int numRows) {
        // "PAYPALISHIRING", 3  -----  "PAHNAPLSIIGYIR".
        //  P   A   H   N
        //  A P L S I I G
        //  Y   I   R
        if(numRows == 1) return s;
        int T = 2 * numRows - 2;
        int N = s.length() / T + 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < N; j++){
                if((i + j * T) < s.length())
                    sb.append(s.charAt(i + j * T));
                if((!(i == 0 || i == numRows - 1)) && ((j + 1) * T - i) < s.length())
                    sb.append(s.charAt((j + 1) * T - i));
            }
        }

        //System.out.println(sb.toString());
        return sb.toString();
    }
}
