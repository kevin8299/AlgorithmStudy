package com.leetcode.combination_sum3;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Test {

    public static void main(String[] args){
        System.out.println("test");
        Solution s = new Solution();
        //List<List<Integer>> re = s.combinationSum3(3, 7);
        List<List<Integer>> re = s.combinationSum3(3, 9);

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
