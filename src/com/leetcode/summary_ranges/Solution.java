package com.leetcode.summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        //  {0,1,2,4,5,7}  ---  ["0->2","4->5","7"]
        List<String> out = new ArrayList<>();
        if(nums.length != 0){
            int idx = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1)
                    continue;
                else{
                    String str;
                    if (idx == i - 1)
                        str = String.valueOf(nums[idx]);
                    else
                        str = nums[idx] + "->" + nums[i - 1];
                    out.add(str);
                    idx = i;
                }
            }
            //System.out.println(idx + "  " + i);
            String str1;
            if (idx == nums.length - 1)
                str1 = String.valueOf(nums[idx]);
            else
                str1 = nums[idx] + "->" + nums[nums.length - 1];
            out.add(str1);
        }
        return out;
    }
}
