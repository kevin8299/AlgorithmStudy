package com.leetcode.contains_duplicate2;

/**
 * Created by Administrator on 2016/4/21.
 */
public class Test {
    public static void main(String[] args){
        int[] ds = {1,2,3,4,5,2};
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(ds, 3));
    }
}
