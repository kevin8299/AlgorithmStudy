package com.leetcode.count_of_range_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Solution_DFS {  //Error Interpretation of the question! Abort
    public int countRangeSum(int[] nums, int lower, int upper) {
        //  {-2, 5, -1}   lower = -2, upper = 2  ==>
        //   [0, 0]: -2, [2, 2]: -1, [0, 2]: 2  ==>  3
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        boolean first = true;
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        int sum = 0;
        dfs(nums, lower, upper, 0, sum, part, all, first);

        count = all.size();
        return count;
    }

    public void dfs(int[] nums, int lower, int upper, int start, int sum, List<Integer> part, List<List<Integer>> all, boolean first){
        if(!first && sum <= upper && sum >= lower) {
            all.add(new ArrayList<Integer>(part));
            first = false;
            for(int i =start; i < nums.length; i++){
                part.add(nums[i]);
                dfs(nums, lower, upper, i + 1, sum + nums[i], part, all, first);
                part.remove(part.size() - 1);
            }
        }
        else if(!first && (sum > upper || sum < lower))
            return;
        else{
            first = false;
            for(int i =start; i < nums.length; i++){
                part.add(nums[i]);
                dfs(nums, lower, upper, i + 1, sum + nums[i], part, all, first);
                part.remove(part.size() - 1);
            }
        }
    }
}
