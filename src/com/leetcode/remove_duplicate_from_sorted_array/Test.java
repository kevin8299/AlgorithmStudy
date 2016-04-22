package com.leetcode.remove_duplicate_from_sorted_array;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Test {
    public static void main(String[] args){
        int[] ds = {1,1,1,2,2,3};
        Solution s = new Solution();
        int len = s.removeDuplicates(ds);
        for(int i = 0; i < len; i++)
            System.out.print(ds[i] + " ");
    }
}
