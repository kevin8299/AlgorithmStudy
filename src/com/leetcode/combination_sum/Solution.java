package com.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, result, part, 0, 0);

        return result;
    }

    void getCombination(int[] candidates, int target, List<List<Integer>> result, List<Integer> part, int x, int sum){

        if(sum == target) result.add(new ArrayList<Integer>(part));
        else if(sum > target) return;
        else for(int i = x; i < candidates.length; i++) {
            part.add(candidates[i]);
            getCombination(candidates, target, result, part, i, sum + candidates[i]);
            part.remove(part.size() - 1);
        }
    }

}
