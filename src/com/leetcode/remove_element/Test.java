package com.leetcode.remove_element;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Test {
    public static void main(String[] args){
        int[] d = {3,2,2,3};
        int v = 3;
        Solution s = new Solution();
        int len = s.removeElement(d, v);
        for(int i = 0; i < len; i++)
            System.out.print(d[i] + " ");
    }
}
