package com.leetcode.combination_sum3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Solution {
    int k, n;
    int[] arr = {1,2,3,4,5,6,7,8,9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> part = new ArrayList<>();
        findCombination(result, part, 0, 0);
        return result;
    }

    public void findCombination(List<List<Integer>> result, List<Integer> part, int start, int sum){
        if(sum == n && part.size() == k)
            result.add(new ArrayList<Integer>(part));
        else if(sum > n)
            return;
        else for(int i = start; i < arr.length; i++){
                part.add(arr[i]);
                findCombination(result, part, i + 1, sum + arr[i]);
                part.remove(part.size() - 1);
            }
    }

}
