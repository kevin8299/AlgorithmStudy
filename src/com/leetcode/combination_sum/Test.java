package com.leetcode.combination_sum;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Test {

    public static void main(String[] args){
        System.out.println("test");
        int[] c = {2, 3, 6, 7};
        int t = 7;
        Solution s = new Solution();
        Solution_BuildTree sT = new Solution_BuildTree();
        //List<List<Integer>> re = s.combinationSum(c, t);
        List<List<Integer>> re = sT.combinationSum(c, t);

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
