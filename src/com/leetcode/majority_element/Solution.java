package com.leetcode.majority_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        //  {1,2,3,4,4,4,5,6,7,4}
        Arrays.sort(nums);
        int t = 1;
        int idx = 0;
        int dMax = nums[0], tMax = t;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[idx] == 0) {
                ++t;
                if(i == nums.length - 1)
                    if(tMax < t) {
                        tMax = t;
                        dMax = nums[i - 1];
                    }
            }
            else{
                if(tMax < t) {
                    tMax = t;
                    dMax = nums[i - 1];
                }
                t = 1;
                idx = i;
            }
        }
        return dMax;
    }

    public int majorityElement1(int[] nums) {
        //  {1,2,3,4,4,4,5,6,7,4}
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        int k = 0, v = 0;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry e = (Map.Entry)iter.next();
            int key = (Integer)e.getKey();
            int value = (Integer)e.getValue();
            if(v < value){
                k = key;
                v = value;
            }
        }
        return k;
    }
}
