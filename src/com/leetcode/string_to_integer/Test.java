package com.leetcode.string_to_integer;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Test {
    public static void main(String[] args){
        String str1 = "2147483648";
        Solution s = new Solution();
        int result = s.myAtoi(str1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(result);
    }
}
