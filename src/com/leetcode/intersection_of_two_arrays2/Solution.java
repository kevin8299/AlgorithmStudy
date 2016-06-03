package com.leetcode.intersection_of_two_arrays2;

import java.util.*;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        //{1, 2, 2, 1} {2, 2} => {2,2}
        if(nums1 == null || nums2 == null ||nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(map1.containsKey(nums1[i])){
                int num = map1.get(nums1[i]);
                map1.put(nums1[i], ++num);
            }
            else
                map1.put(nums1[i], 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            if(map2.containsKey(nums2[i])){
                int num = map2.get(nums2[i]);
                map2.put(nums2[i], ++num);
            }
            else
                map2.put(nums2[i], 1);
        }

        Map<Integer, Integer> res = new HashMap<>();
        for(int key: map1.keySet()){
            if(map2.containsKey(key)){
                int t1 = map1.get(key);
                int t2 = map2.get(key);
                int count = t1 > t2 ? t2 : t1;
                res.put(key, count);
            }
        }

        int len = 0;
        for(int key: res.keySet()){
            len += res.get(key);
        }

        int[] o = new int[len];
        int idx = 0;
        for(int key: res.keySet()){
            int n = res.get(key);
            for(int i = 0; i < n; i++){
                o[idx++] = key;
            }
        }

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
