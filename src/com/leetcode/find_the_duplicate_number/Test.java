package com.leetcode.find_the_duplicate_number;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Test {
    public static void main(String[] args){
        int[] ds = {1,2,3,4,5,6,7,8,9,9};
        Solution s = new Solution();
        System.out.println(s.findDuplicate(ds));

//        for(int i = 0; i < ds.length; i++)
//            for(int j = i + 1; j < ds.length; j++)
//                if(ds[j] > ds[i]){
//                    ds[j] = ds[i] + ds[j];
//                    ds[i] = ds[j] - 2 * ds[i];
//                    ds[i] = (ds[i] + ds[j]) / 2;
//                    ds[j] = ds[j] - ds[i];
//                }
//        for(int i = 0; i < ds.length; i++)
//            System.out.print(ds[i] + " ");
    }
}
