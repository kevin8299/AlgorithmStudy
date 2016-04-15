package com.leetcode.basic_calculator;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("test");

        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "21";
        String s5 = "1-11";
        String s6 = "1-(5)";

        Solution s = new Solution();
        System.out.println(s.calculate(s1));
        System.out.println(s.calculate(s2));
        System.out.println(s.calculate(s3));
        System.out.println(s.calculate(s4));
        System.out.println(s.calculate(s5));
        System.out.println(s.calculate(s6));
    }
}
