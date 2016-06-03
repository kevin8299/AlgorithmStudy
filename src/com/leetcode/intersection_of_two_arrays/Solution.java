package com.leetcode.intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        //{1, 2, 2, 1} {2, 2} => {2}
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        long d1 = 0;
        for(int i = 0; i < nums1.length; i++) {
            d1 |= 1 << nums1[i];
        }

        long d2 = 0;
        for(int j = 0; j < nums2.length; j++) {
            d2 |= 1 << nums2[j];
        }

        long inter = d1 & d2;
        List<Integer> res = new ArrayList<>();
        int idx = 0, x;
        while(inter != 0) {
            if((inter | 1) != 0)
                res.add(idx);
            inter = inter >> 1;
            idx++;
        }

        int[] o = new int[res.size()];
        for(int i = 0; i < o.length; i++)
            o[i] = res.get(i);
        return o;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        //{1, 2, 2, 1} {2, 2} => {2}
        if(nums1 == null || nums2 == null ||nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int prev1 = nums1[0] - 1, prev2 = nums2[0] - 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            if(prev1 != nums1[i]) {
                for (int j = 0; j < nums2.length; j++) {
                    if(prev2 != nums2[j]) {
                        if(nums1[i] == nums2[j])
                            res.add(nums1[i]);
                    }
                    prev2 = nums2[j];
                }
            }
            prev1 = nums1[i];
            prev2 = nums2[0] - 1;
        }

        int[] o = new int[res.size()];
        for(int i = 0; i < o.length; i++)
            o[i] = res.get(i);
        return o;
    }
}
