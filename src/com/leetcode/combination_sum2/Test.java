package com.leetcode.combination_sum2;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Test {

    public static void main(String[] args){
        System.out.println("test");
        int[] c = {10, 1, 2, 7, 6, 1, 5};  //  1, 1, 2, 5, 6, 7, 10
        int t = 8;
        Solution s = new Solution();
        List<List<Integer>> re = s.combinationSum2(c, t);

        if(re == null)
            System.out.println("None is compatible !");
        else
            for(List<Integer> comb: re){
                for(Integer i: comb)
                System.out.print(i + " ");
                System.out.println();
            }
    }

}
