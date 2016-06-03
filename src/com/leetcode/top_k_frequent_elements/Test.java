package com.leetcode.top_k_frequent_elements;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Test {

    public static void main(String[] args){
        int[] ds = {-1, -1};
        int k = 1; // [1,2]

        Solution s = new Solution();
        List<Integer> res = s.topKFrequent(ds, k);
        for(int i: res)
            System.out.print(i + " ");
    }
}
