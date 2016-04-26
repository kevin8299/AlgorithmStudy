package com.leetcode.summary_ranges;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Test {
    public static void main(String[] args){
        int[] ds = {0,1,2,4,5,7};  // ["0->2","4->5","7"]
        Solution s = new Solution();
        List<String> result = s.summaryRanges(ds);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + "  ");

        System.out.println(ds[1] - ds[0]);
        System.out.println(ds[2] - ds[1]);
        System.out.println(ds[2] - ds[0]);
    }
}
