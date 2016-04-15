package com.leetcode.combination_sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, result, part, 0, 0);

        return result;
    }

    void getCombination(int[] candidates, int target, List<List<Integer>> result, List<Integer> part, int x, int sum){
//        for(int d: part)
//            System.out.print(d + " ");
//        System.out.println();
        if(sum == target) result.add(new ArrayList<Integer>(part));
        else if(sum > target) return;
        else for(int i = x; i < candidates.length; i++) {  //  1, 1, 2, 5, 6, 7, 10
                part.add(candidates[i]);
                getCombination(candidates, target, result, part, i + 1, sum + candidates[i]);
                part.remove(part.size() - 1);
                while(i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                    i++;
        }
    }

}
