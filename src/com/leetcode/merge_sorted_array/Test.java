package com.leetcode.merge_sorted_array;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Test {
    public static void main(String[] args){
        int[] a = {1,3,6,7,11};
        int[] b = {4,8,10};
        int[] c = new int[a.length + b.length];
        for(int i = 0; i < a.length; i++)
            c[i] = a[i];

        Solution s = new Solution();
        s.merge(c, c.length, b, b.length);
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
    }
}
