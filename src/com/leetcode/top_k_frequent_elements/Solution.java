package com.leetcode.top_k_frequent_elements;

import java.util.*;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // {1,1,1,2,2,3}  +  2  =>  [1,2]
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        List<Data> res = new ArrayList<>();
        for(int key: map.keySet())
            res.add(new Data(key, map.get(key)));

        Collections.sort(res);

        List<Integer> o = new ArrayList<>();
        for(int i = 0; i < k; i++)
            o.add(res.get(i).data);

        return o;
    }

    class Data implements Comparable<Data> {
        int data, num;

        Data(int d, int n){
            data = d;
            num = n;
        }

        public int compareTo(Data d){
            if(num > d.num) return -1;
            else if(num == d.num) return 0;
            else return 1;
        }
    }


}
