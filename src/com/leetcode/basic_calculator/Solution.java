package com.leetcode.basic_calculator;

import java.util.Stack;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Solution {
    //"(1+(4+5+2)-3)+(6+8)";
    public int calculate(String s) {
        Stack<Integer> vStack = new Stack<Integer>();

        int res = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                if(Character.isDigit(c)){
                    int d = c - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                        d = d * 10 +  s.charAt(++i) - '0';

                    res += sign * d;
                    //System.out.println(res);
                }
                else if(c == '+')
                    sign = 1;
                else if(c == '-')
                    sign = -1;
                else if(c == '('){
                    vStack.push(res);
                    res = 0;
                    vStack.push(sign);
                    sign = 1;
                }
                else if(c == ')'){
                    sign = vStack.pop();
                    res = sign * res + vStack.pop();
                    sign = 1;
                }
            }
        }

        return res;
    }
}
